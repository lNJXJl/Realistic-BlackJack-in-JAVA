# Realistic-BlackJack-in-JAVA
Konsolowa implementacja gry BlackJack napisana w języku Java z pełną funkcjonalnością i systemem zarządzania pieniędzmi.
--Funkcjonalności--
**Podstawowa mechanika gry**
- Pełna implementacja BlackJack - zgodna z oficjalnymi zasadami
- Inteligentny system Asów - automatyczne dostosowywanie wartości (11 lub 1)
- Logika dealera - dealer dobiera do wartości 17
- Detekcja bust - dla gracza i dealera
- System remisów - z automatycznym zwrotem stawki
- Zarządzanie Talią od 52 kart do 0

**System pieniędzy**
Zarządzanie budżetem - startowy kapitał 100 jednostek
System obstawiania - walidacja stawek
Wypłaty wygranych - 1:1 dla standardowych wygranych
Zabezpieczenie ALL-IN - ochrona przed wczesnym opuszczeniem gry

**Dodatkowe funkcje**
Automatyczne tasowanie - gdy skończą się karty w talii
Polskie teksty - poprawna odmiana słowa "karta"
Dev Menu - narzędzia deweloperskie do testowania
Kody cheatów - do podglądania kart dealera (444, 455)

Struktura projektu
src/
├── Main.java
└── Engine/
    ├── Cards.java      # Klasa karty z wartościami BlackJack
    ├── Deck.java       # Zarządzanie talią (52 karty)
    ├── Hand.java       # Logika gracza i rozgrywki
    ├── Dealer.java     # Sztuczna inteligencja dealera
    └── Money.java      # System finansowy
    
**Jak uruchomić**

- Sklonuj repozytorium:
gh repo clone lNJXJl/Realistic-BlackJack-in-JAVA

- Skompiluj projekt:

bashjavac -d out src/Main.java src/Engine/*.java

- Uruchom grę:
bashjava -cp out Main

- Lub pobierz projekt i odpal w terminalu IDE.
**Zasady gry**

Cel gry: Osiągnij wartość jak najbliższą 21, nie przekraczając jej

Wartości kart:
Karty 2-10: wartość nominalna
Figury (J, Q, K): 10 punktów
As: 11 lub 1 (automatycznie dostosowywane)


Dealer: Dobiera do 17, potem stoi
Bust: Przekroczenie 21 oznacza natychmiastową przegraną


Menu główne
1. Graj - rozpocznij rozgrywkę
2. Balans - sprawdź aktualny stan konta
3. Dev Menu - narzędzia deweloperskie
0. Wyjdź - zakończ program

W trakcie gry

1. HIT - dobierz kartę
2. STAND - zakończ swój ruch
444 - [CHEAT] pokaż karty dealera
455 - [CHEAT] pokaż liczbę kart w talii
0. Wyjdź - tylko po zakończeniu rundy

**Przykład rozgrywki**

Nowa partia
Aktualny balans: 100
Podaj zakład: 
100
ALL IN!
Menu gry
Karta Dealera 9 (Red) Hearts (♥)
1. 7 (Black) Clubs (♣)
2. K (Black) Clubs (♣)
Wartość Ręki: 17
1. HIT
2. STAND
Dobrano: 2 karty
Balans: 0
Zakład: 100
0. Wyjdź
2
Wstrzymano się
Dealer Rozpoczyna Gre
Dealer odsłania zakrytą kartę: 4 (Black) Clubs (♣)
Dealer dobiera kartę: 9 (Red) Diamonds (♦)
Wartość ręki dealera: 22
Dealer Busted!
Karty Dealera: 
1. 9 (Red) Hearts (♥)
2. 4 (Black) Clubs (♣)
3. 9 (Red) Diamonds (♦)
Gracz wygrywa - dealer ma bust!
Dealer kończy z wartością: 22
Wygrałeś 100. Posiadasz teraz: 200
Nowa partia
Aktualny balans: 200
Podaj zakład:

**Techniczne szczegóły**

Język: Java 17
Architektura: Obiektowa z separacją odpowiedzialności
Zarządzanie pamięcią: Automatyczne czyszczenie po każdej rundzie
Obsługa błędów: Walidacja danych wejściowych i zabezpieczenia

**Funkcje deweloperskie**
Dev Menu umożliwia:

- Podgląd całej talii
- Losowanie pojedynczych kart
- Reset talii
- Testowanie systemu ręki z oddzielnym budżetem

Autor NJXJ
Projekt stworzony jako nauka programowania obiektowego w Javie w wolnym czasie.

**Uwagi**
Gra wymaga wprowadzania liczb z klawiatury
Wszystkie komunikaty w języku polskim
Automatyczne zabezpieczenia przed nieprawidłowymi ruchami
System anti-rage quit - nie można wyjść w trakcie rundy
