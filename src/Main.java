import classes.*;
import classesinput.Filters;
import classesinput.Input;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static checker.CheckStyleConstants.CHECKSTYLE_POINTS;

public class Main {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();
        Input inputData = objectMapper.readValue(new File(args[0]), Input.class);
        //Creating the accounts list
        ArrayList<User> accountsLists = new ArrayList<>();
        for (int i = 0; i < inputData.getUsers().size(); i++) {
            User newlist = new User();
            newlist.getCredentials().setAccountType(
                    inputData.getUsers().get(i).getCredentials().getAccountType());
            newlist.getCredentials().setName(
                    inputData.getUsers().get(i).getCredentials().getName());
            newlist.getCredentials().setPassword(
                    inputData.getUsers().get(i).getCredentials().getPassword());
            newlist.getCredentials().setCountry(
                    inputData.getUsers().get(i).getCredentials().getCountry());
            newlist.getCredentials().setBalance(
                    inputData.getUsers().get(i).getCredentials().getBalance());
            accountsLists.add(newlist);
        }

        //Creating the movies list
        ArrayList<Movie> movieLists = new ArrayList<>();
        for (int i = 0; i < inputData.getMovies().size(); i++) {
            Movie newlist = new Movie();
            newlist.setName(inputData.getMovies().get(i).getName());
            newlist.setYear(inputData.getMovies().get(i).getYear());
            newlist.setDuration(inputData.getMovies().get(i).getDuration());
            newlist.setActors(inputData.getMovies().get(i).getActors());
            newlist.setGenres(inputData.getMovies().get(i).getGenres());
            newlist.setCountriesBanned(inputData.getMovies().get(i).getCountriesBanned());
            movieLists.add(newlist);
        }

        Data database = new Data();
        ArrayList<String> nextpages = new ArrayList<>();
        database.setCurrentMoviesList(new ArrayList<>());

        nextpages.add("login");
        nextpages.add("register");
        Page newpage = new Page("homepage neautentificat", nextpages);
        database.setCurrentPage(newpage);

        String Seemovie = null;

        for (int numberaction = 0; numberaction < inputData.getActions().size(); numberaction ++) {
            String actionType = inputData.getActions().get(numberaction).getType();
            if (actionType.equals("change page")) {
                String page = inputData.getActions().get(numberaction).getPage();
                int sem = 0;
                for (int i = 0; i < database.getCurrentPage().getNextPages().size(); i++) {
                    if (page.equals(database.getCurrentPage().getNextPages().get(i))) {
                        sem = 1;
                        break;
                    }
                }
                if (sem == 0) {
                    ClassOutput classOutput = new ClassOutput();
                    classOutput.setError("Error");
                    classOutput.setCurrentUser(null);
                    classOutput.setCurrentMoviesList(new ArrayList<>());
                    output.addPOJO(classOutput);
                } else {
                    ArrayList<String> pages = new ArrayList<>();
                    if (page.equals("homepage autentificat")) {
                        pages.add("movies");
                        pages.add("upgrades");
                        pages.add("logout");
                    }
                    if (page.equals("movies")) {
                        pages.add("homepage autentificat");
                        pages.add("see details");
                        pages.add("logout");
                        pages.add("movies");

                        database.setCurrentMoviesList(new ArrayList<>());
                        ArrayList<Movie> newMovies = new ArrayList<>();
                        String country = database.getCurrentUser().getCredentials().getCountry();
                        for (Movie movieList : movieLists) {
                            int semCountries = 1;
                            for (int j = 0; j < movieList.getCountriesBanned().size(); j++) {
                                if (country.equals(movieList.getCountriesBanned().get(j))) {
                                    semCountries = 0;
                                    break;
                                }
                            }
                            if (semCountries == 1) {
                                newMovies.add(movieList);
                            }
                        }
                        database.getCurrentMoviesList().addAll(newMovies);

                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError(null);
                        User newuser = new User(database.getCurrentUser());
                        classOutput.setCurrentUser(newuser);

                        ArrayList<Movie> moviesOut = new ArrayList<>();
                        for (int p = 0; p < database.getCurrentMoviesList().size(); p++) {
                            Movie newmovie = new Movie(database.getCurrentMoviesList().get(p));
                            moviesOut.add(newmovie);
                        }
                        classOutput.setCurrentMoviesList(moviesOut);
                        output.addPOJO(classOutput);
                        Page newPage = new Page("movies", pages);
                        database.setCurrentPage(newPage);
                    }
                    if (page.equals("upgrades")) {
                        pages.add("homepage autentificat");
                        pages.add("movies");
                        pages.add("logout");
                        Page newPage = new Page("upgrades", pages);
                        database.setCurrentPage(newPage);
                    }
                    if (page.equals("see details")) {
                        pages.add("homepage autentificat");
                        pages.add("movies");
                        pages.add("upgrades");
                        pages.add("logout");
                        String movieName = inputData.getActions().get(numberaction).getMovie();
                        int semMovie = 0;

                        for (int k = 0; k < database.getCurrentMoviesList().size(); k++) {
                            if (database.getCurrentMoviesList()
                                    .get(k).getName().equals(movieName)) {
                                semMovie = 1;
                                break;
                            }
                        }
                        if (semMovie == 0) {
                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError("Error");
                            classOutput.setCurrentUser(null);
                            classOutput.setCurrentMoviesList(new ArrayList<>());
                            output.addPOJO(classOutput);
                        } else {
                            Seemovie = movieName; //saving the movie
                            ArrayList<Movie> newmovielist = new ArrayList<>();
                            Movie newmovie = new Movie();
                            //searching for movie
                            for (int i = 0; i < database.getCurrentMoviesList().size(); i++) {
                                if (database.getCurrentMoviesList().get(i)
                                        .getName().equals(Seemovie)) {
                                    newmovie = new Movie(database.getCurrentMoviesList().get(i));
                                    break;
                                }
                            }
                            newmovielist.add(newmovie);
                            //creating output
                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError(null);
                            User newuser = new User(database.getCurrentUser());
                            classOutput.setCurrentUser(newuser);
                            classOutput.setCurrentMoviesList(newmovielist);
                            output.addPOJO(classOutput);

                            Page pageadded = new Page(page, pages);
                            database.setCurrentPage(pageadded);
                        }
                        continue;
                    }
                    if (page.equals("logout")) {
                        database.setCurrentUser(null);
                        database.setCurrentMoviesList(new ArrayList<>());
                        Seemovie = null;
                        database.setCurrentPage(newpage);
                    } else {
                        Page pageadded = new Page(page, pages);
                        database.setCurrentPage(pageadded);
                    }
                }
            } else {
                //on page action
                String feauture = inputData.getActions().get(numberaction).getFeature();
                if (feauture.equals("login")) {
                    if (database.getCurrentPage().getName().equals("login")) {
                        database.setCurrentUser(new User());
                        Credentials loginCredentials =
                                inputData.getActions().get(numberaction).getCredentials();
                        int isAccountGood = 0;
                        for (User accountsList : accountsLists) {
                            if (loginCredentials.getName().equals(
                                    accountsList.getCredentials().getName())
                                    && loginCredentials.getPassword().equals(
                                    accountsList.getCredentials().getPassword())) {
                                //set current account
                                database.setCurrentUser(accountsList);
                                isAccountGood = 1;
                                break;
                            }
                        }
                        if (isAccountGood == 1) {
                            //set current page
                            ArrayList<String> pages = new ArrayList<>();
                            pages.add("movies");
                            pages.add("upgrades");
                            pages.add("logout");
                            Page pageadded = new Page("homepage autentificat", pages);
                            database.setCurrentPage(pageadded);

                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError(null);
                            User newuser = new User(database.getCurrentUser());
                            classOutput.setCurrentUser(newuser);
                            classOutput.setCurrentMoviesList(new ArrayList<>());
                            output.addPOJO(classOutput);
                        } else {
                            database.setCurrentUser(null);
                            database.setCurrentPage(newpage);
                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError("Error");
                            classOutput.setCurrentUser(null);
                            classOutput.setCurrentMoviesList(new ArrayList<>());
                            output.addPOJO(classOutput);
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("register")) {
                    if (database.getCurrentPage().getName().equals("register")) {
                        Credentials registerCredentials =
                                inputData.getActions().get(numberaction).getCredentials();
                        int isAccountGood = 1;
                        for (User accountsList : accountsLists) {
                            if (registerCredentials.getName().equals(
                                    accountsList.getCredentials().getName())
                                    && registerCredentials.getPassword().equals(
                                    accountsList.getCredentials().getPassword())) {
                                isAccountGood = 0;
                                break;
                            }
                        }
                        if (isAccountGood == 1) {
                            //adding account
                            database.setCurrentUser(new User());
                            database.setCurrentMoviesList(new ArrayList<>());
                            User accouter = new User();
                            accouter.getCredentials().setName(registerCredentials.getName());
                            accouter.getCredentials().setPassword(
                                    registerCredentials.getPassword());
                            accouter.getCredentials().setBalance(registerCredentials.getBalance());
                            accouter.getCredentials().setCountry(registerCredentials.getCountry());
                            accouter.getCredentials().setAccountType(
                                    registerCredentials.getAccountType());
                            accountsLists.add(accouter);
                            //set current account
                            database.getCurrentUser().setCredentials(registerCredentials);
                            //set current page
                            ArrayList<String> pages = new ArrayList<>();
                            pages.add("movies");
                            pages.add("upgrades");
                            pages.add("logout");
                            Page pageadded = new Page("homepage autentificat", pages);
                            database.setCurrentPage(pageadded);

                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError(null);
                            User newuser = new User(database.getCurrentUser());
                            classOutput.setCurrentUser(newuser);
                            classOutput.setCurrentMoviesList(new ArrayList<>());
                            output.addPOJO(classOutput);
                        } else {
                            database.setCurrentUser(null);
                            database.setCurrentPage(newpage);
                            ClassOutput classOutput = new ClassOutput();
                            classOutput.setError("Error");
                            classOutput.setCurrentUser(null);
                            classOutput.setCurrentMoviesList(new ArrayList<>());
                            output.addPOJO(classOutput);
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("search")) {
                    if (database.getCurrentPage().getName().equals("movies")) {
                        String startWith = inputData.getActions().get(numberaction).getStartsWith();
                        database.search(startWith, output);
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("filter")) {
                    if (database.getCurrentPage().getName().equals("movies")) {
                        database.setCurrentMoviesList(new ArrayList<>());
                        ArrayList<Movie> newMovies = new ArrayList<>();
                        String country = database.getCurrentUser().getCredentials().getCountry();
                        for (Movie movieList : movieLists) {
                            int semCountries = 1;
                            for (int j = 0; j < movieList.getCountriesBanned().size(); j++) {
                                if (country.equals(movieList.getCountriesBanned().get(j))) {
                                    semCountries = 0;
                                    break;
                                }
                            }
                            if (semCountries == 1) {
                                newMovies.add(movieList);
                            }
                        }
                        database.getCurrentMoviesList().addAll(newMovies);
                        Filters newfilter = inputData.getActions().get(numberaction).getFilters();
                        database.filter(newfilter, output);
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("purchase")) {
                    if (database.getCurrentPage().getName().equals("see details")) {
                        if (Seemovie != null) {
                            database.purchase(Seemovie, output);
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("watch")) {
                    if (database.getCurrentPage().getName().equals("see details")) {
                        if (Seemovie != null) {
                            database.watch(Seemovie, output);
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("like")) {
                    if (database.getCurrentPage().getName().equals("see details")) {
                        if (Seemovie != null) {
                            database.like(Seemovie, output);
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("rate")) {
                    if (database.getCurrentPage().getName().equals("see details")) {
                        if (Seemovie != null) {
                            int rate = inputData.getActions().get(numberaction).getRate();
                            if (rate <= CHECKSTYLE_POINTS / 2) {
                                database.rate(Seemovie, output, rate);
                            } else {
                                ClassOutput classOutput = new ClassOutput();
                                classOutput.setError("Error");
                                classOutput.setCurrentUser(null);
                                classOutput.setCurrentMoviesList(new ArrayList<>());
                                output.addPOJO(classOutput);
                            }
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("buy premium account")) {
                    if (database.getCurrentPage().getName().equals("upgrades")) {
                        if (database.getCurrentUser().getCredentials().
                                getAccountType().equals("standard")) {
                            database.buyPremium();
                        }
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                    continue;
                }
                if (feauture.equals("buy tokens")) {
                    if (database.getCurrentPage().getName().equals("upgrades")) {
                        int count = inputData.getActions().get(numberaction).getCount();
                        database.buyTokens(count);
                    } else {
                        ClassOutput classOutput = new ClassOutput();
                        classOutput.setError("Error");
                        classOutput.setCurrentUser(null);
                        classOutput.setCurrentMoviesList(new ArrayList<>());
                        output.addPOJO(classOutput);
                    }
                }
            }
        }
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File("src/Output"), output);
        objectWriter.writeValue(new File(args[1]), output);
    }
}
