

# Tema POO  - Proiect 1

## Explicatii implementare
Am folosit clasa Main pentru a crea parserul in functie de comanda data, iar in functie de
comanda am realizat rezolvarea taskului ori in main, ori intr-o clasa data.<br>
Exista doua tipuri de comenzi "change page" si "on page", pentru a verifica daca o comanda se executa
pe o pagina corecta, am creat o clasa de tipul Page care are 2 campuri, un camp cu numele paginii
in care ne aflam si o lista de alte stringuri (numele paginilor) in care putem sa mergem. Astfel
verific daca am voie sa ma mut in acea pagina. <br>
Pentru am imi memora toate datele am creat o clasa de tipul Data care va fi ca o baza de date, in care
voi pastra toate informatiile relevante si pentru afisare, adica pagina curenta, utilizatorul curent
si lista curenta de filme.
### Alegere design pattern
Pentru design pattern am ales singletonul, fiind cel mai simplu de utilizat si relevant, deoarece
am nevoie ca baza mea de date sa fie initializata o singura data la rularea programului.

## Ierarhia claselor:
### Clase pentru citirea datelor:

Clasa AccountsList - este o clasa ce ma ajuta sa citesc un utilizator dat.<br><br>
Clasa CredentialsInput - este o clasa ce doar imi creeaza o instanta de tipul credentials. Acest
lucru fiind necesar deoarece in fisierul de intrare datele sunt date dupa urmatorul tip: <br>
"credentials": {
"name": "Eduard",
"password": "secret",
"accountType": "standard",
"country": "Romania",
"balance": "50"
} <br>
Fara aceasta clasa nu puteam face sa apara si acel mesaj "credentials".<br><br>
Clasa Actions - este folosita pentru citirea unui intregi actiuni din fisierul de intrare. <br><br>
Clasa Sort - contine 2 stringuri care vor memora tipul de sortare pentru rating si pentru durata.
(crescatoare sau descrescatoare) <br><br>
Clasa Contains - contine 2 liste de stringuri corespunzatoare listei de actori si de genuri. Aceste
liste vor fi folosite pentru a elimina un film din lista curenta de filme, daca contine unul dintre 
actori, sau un gen specificat. <br><br>
Clasa Filters - ce contine 2 instante, una pentru Sort si una pentru Contains. <br><br>
Clasa Input - contine 3 instante, una pentru utilizatori (de tipul CredentialsInput), o lista de
filme si o lista de actiuni.

### Clase pentru implementare:
Clasa Credentials - contine doar informatiile initiale (care sunt primite din fisierul de intrare) 
ale unui utilizator, cum ar fi: numele, parola, tipul de cont, tara si balanta curenta.<br><br>
Clasa User - ce contine toate informatiile unui utilizator, inclusiv numarul de tokenuri detinute,
numarul de filme gratis disponibile si listele de filme cumparate/vazute/
apreciate, sau cele la care a oferit o nota. <br><br>
Clasa Page - explicata putin mai sus, contine doar numele paginii curente si o lista cu toate numele
paginilor in care se poate naviga din pagina curenta. <br><br>
Clasa Movie - contine toate informatiile necesare unui film. <br><br>
Clasa Data - pe langa baza de date pe care o memoreaza, are si cateva metode ce implementeaza anumite 
cerinte, cum ar fi: search, filter, purchase, watch, like, rate, metode cu nume sugestive ce realizeaza
anumite operatiuni asupra filmelor. Pe langa acestea, mai contine inca 2 metode specifice utilizatorului,
metoda buyPremium (pentru a cumpara un cont premium) si metoda buyTokens (pentru a cumpara tokene).
<br>
Restul logicii si implementari a fost realizata in functia Main.
### Clase pentru afisare:
Clasa ClassOutput - ce contine 3 campuri, un string de eroare ce poate avea ori valoarea null (daca
programul nu a dat eroare), sau valoarea error (daca s-a produs o actiune care nu a putut fi realizata), 
utilizatorul curent si lista curenta de filme.