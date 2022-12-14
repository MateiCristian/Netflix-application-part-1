package Classes;

import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.Collections;

public class Data {
    private Page currentPage;
    private User currentUser;
    private ArrayList<Movie> currentMoviesList;

    public Data() {
        currentPage = new Page();
        currentUser = new User();
        currentMoviesList = new ArrayList<>();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public void search(String startWith, ArrayNode output) {
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (int i = 0; i < currentMoviesList.size(); i++){
            if (currentMoviesList.get(i).getName().startsWith(startWith)){
                newMovies.add(currentMoviesList.get(i));
            }
        }

        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }
    public void filter(Filters newfilter, ArrayNode output) {
        Sort newsort = newfilter.getSort();
        //trebe modificat ceva sa mearga si 8
        if (newsort != null) {
            if (newsort.getRating() != null) {
                if (newsort.getRating().equals("decreasing")) {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getRating() < o2.getRating()) {
                            return -1;
                        } else
                            if (o1.getRating() > o2.getRating())
                                return 1;
                            else
                                return -1;
                    });
                } else {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getRating() > o2.getRating()) {
                            return -1;
                        } else
                            if (o1.getRating() < o2.getRating())
                                return 1;
                            else
                                return 1;
                    });
                }
            }

            if (newsort.getDuration() != null) {
                if (newsort.getDuration().equals("decreasing")) {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getDuration() < o2.getDuration()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                } else {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getRating() > o2.getRating()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                }
            }
        }

        if (newfilter.getContains() != null){
            if (newfilter.getContains().getActors() != null){
                for (int i = 0; i < newfilter.getContains().getActors().size(); i++){
                    for (int j = 0; j < this.currentMoviesList.size(); j++){
                        if (!this.currentMoviesList.get(j).getActors().contains(
                                newfilter.getContains().getActors().get(i))) {
                            this.currentMoviesList.remove(j);
                            j--;
                        }
                    }
                }
            }
            if (newfilter.getContains().getGenre() != null){
                for (int i = 0; i < newfilter.getContains().getGenre().size(); i++){
                    for (int j = 0; j < this.currentMoviesList.size(); j++){
                        if (!this.currentMoviesList.get(j).getGenres().contains(
                                newfilter.getContains().getGenre().get(i))) {
                            this.currentMoviesList.remove(j);
                            j--;
                        }
                    }

                }
            }
        }
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (int p = 0; p < getCurrentMoviesList().size(); p++){
            Movie new_movie = new Movie(getCurrentMoviesList().get(p));
            newMovies.add(new_movie);
        }

        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }

    public void purchase(String seemovie, ArrayNode output) {
        if (currentUser.getCredentials().getAccountType().equals("premium")) {
            int numberFreeMovies = currentUser.getNumFreePremiumMovies();
            if (numberFreeMovies > 0) {
                for (Movie movie : currentMoviesList) {
                    if (movie.getName().equals(seemovie)) {
                        currentUser.getPurchasedMovies().add(movie);
                        currentUser.setNumFreePremiumMovies(currentUser.getNumFreePremiumMovies() - 1);
                        break;
                    }
                }
            }else {
                if (currentUser.getTokensCount() >= 2){
                    for (Movie movie : currentMoviesList) {
                        if (movie.getName().equals(seemovie)) {
                            currentUser.getPurchasedMovies().add(movie);
                            currentUser.setTokensCount(currentUser.getTokensCount() - 2);
                            break;
                        }
                    }
                }
            }
        }else {
            if (currentUser.getTokensCount() >= 2){
                for (Movie movie : currentMoviesList) {
                    if (movie.getName().equals(seemovie)) {
                        currentUser.getPurchasedMovies().add(movie);
                        currentUser.setTokensCount(currentUser.getTokensCount() - 2);
                        break;
                    }
                }
            }
        }

        ArrayList<Movie> newMovies = new ArrayList<>();
        Movie new_movie = new Movie(getCurrentUser().getPurchasedMovies().get(
                getCurrentUser().getPurchasedMovies().size() - 1));
        newMovies.add(new_movie);

        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }

    public void watch(String seemovie, ArrayNode output) {
        int semPurchase = 0, index_semPurchase = 0;
        for (int i = 0; i < currentUser.getPurchasedMovies().size(); i++){
            if (currentUser.getPurchasedMovies().get(i).getName().equals(seemovie)){
                semPurchase = 1;
                index_semPurchase = i;
                break;
            }
        }
        if (semPurchase == 1){
            currentUser.getWatchedMovies().add(currentUser.getPurchasedMovies().get(index_semPurchase));

            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie new_movie = new Movie(getCurrentUser().getWatchedMovies().get(
                    getCurrentUser().getWatchedMovies().size() - 1));
            newMovies.add(new_movie);

            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        }else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    public void like(String seemovie, ArrayNode output) {
        int semWatch = 0, indexsemWatch = 0;
        for (int i = 0; i < currentUser.getWatchedMovies().size(); i++){
            if (currentUser.getWatchedMovies().get(i).getName().equals(seemovie)){
                semWatch = 1;
                indexsemWatch = i;
                break;
            }
        }
        if (semWatch == 1){
            currentUser.getLikedMovies().add(currentUser.getWatchedMovies().get(indexsemWatch));
            currentUser.getWatchedMovies().get(indexsemWatch).setNumLikes(
                    currentUser.getWatchedMovies().get(indexsemWatch).getNumLikes() + 1
            );

            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie new_movie = new Movie(getCurrentUser().getLikedMovies().get(
                    getCurrentUser().getLikedMovies().size() - 1));
            newMovies.add(new_movie);


            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        }else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    public void rate(String seemovie, ArrayNode output, int rate) {

        int semWatch = 0, indexsemWatch = 0;
        for (int i = 0; i < currentUser.getWatchedMovies().size(); i++){
            if (currentUser.getWatchedMovies().get(i).getName().equals(seemovie)){
                semWatch = 1;
                indexsemWatch = i;
                break;
            }
        }
        if (semWatch == 1){
            currentUser.getRatedMovies().add(currentUser.getWatchedMovies().get(indexsemWatch));

            currentUser.getWatchedMovies().get(indexsemWatch).setRating(
                    currentUser.getWatchedMovies().get(indexsemWatch).getRating() + rate
            );
            currentUser.getWatchedMovies().get(indexsemWatch).setNumRatings(
                    currentUser.getWatchedMovies().get(indexsemWatch).getNumRatings() + 1
            );

            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie new_movie = new Movie(getCurrentUser().getRatedMovies().get(
                    getCurrentUser().getRatedMovies().size() - 1));
            newMovies.add(new_movie);


            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        }else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    public void buyPremium() {
        int number = currentUser.getTokensCount();
        if (number >= 10) {
            currentUser.getCredentials().setAccountType("premium");
            currentUser.setTokensCount(number - 10);
        }
    }

    public void buyTokens(int count) {
        currentUser.setTokensCount(currentUser.getTokensCount() + count);
        int number = Integer.parseInt(currentUser.getCredentials().getBalance());
        int devide = number - count;
        String numberValue = String.valueOf(devide);
        currentUser.getCredentials().setBalance(numberValue);
    }
    @Override
    public String toString() {
        return "Data{" +
                "currentPage=" + currentPage +
                ", currentUser=" + currentUser +
                ", currentMoviesList=" + currentMoviesList +
                '}';
    }
}
