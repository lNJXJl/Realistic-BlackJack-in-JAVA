# Realistic-BlackJack-in-JAVA
Konsolowa implementacja gry BlackJack napisana w języku Java z pełną funkcjonalnością, systemem zarządzania pieniędzmi oraz systemem zapisu stanu gry.
--Funkcjonalności--

**Podstawowa mechanika gry**
- Pełna implementacja BlackJack zgodna z oficjalnymi zasadami
- Inteligentny system Asów automatyczne dostosowywanie wartości (11 lub 1)
- Logika dealera dealer dobiera do wartości 17
- Detekcja bust dla gracza i dealera
- System remisów z automatycznym zwrotem stawki
- Zarządzanie Talią od 52 kart do 0
- Opcja zapisu stanu gry jak i usuniecia

**System pieniędzy**
- Zarządzanie budżetem startowy kapitał 100 jednostek
- System obstawiania walidacja stawek
- Wypłaty wygranych 1:1 dla standardowych wygranych
- Zabezpieczenie ALL-IN ochrona przed wczesnym opuszczeniem gry

**Dodatkowe funkcje**
- Automatyczne tasowanie gdy skończą się karty w talii
- Polskie teksty poprawna odmiana słowa "karta"
- Dev Menu narzędzia deweloperskie do testowania
- Kody cheatów do podglądania kart dealera (444, 455, 400)

**Jak uruchomić**

- Sklonuj repozytorium:
gh repo clone lNJXJl/Realistic-BlackJack-in-JAVA

- Skompiluj projekt:

bashjavac -d out src/Main.java src/Engine/*.java

- Uruchom grę:
bashjava -cp out Main

- Lub pobierz projekt i odpal w terminalu IDE.
**Zasady gry**

Cel gry: Osiągnij wartość jak najbliższą 21, nie przekraczając jej, oraz posiadajac wartość większa niż krupier.

Wartości kart:
- Karty 2-10: wartość nominalna
- Figury (J, Q, K): 10 punktów
- As: 11 lub 1 (automatycznie dostosowywane)


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


Autor NJXJ
Projekt stworzony jako nauka programowania obiektowego w Javie w wolnym czasie.

**Uwagi**
Gra wymaga wprowadzania liczb z klawiatury
Wszystkie komunikaty w języku polskim
Automatyczne zabezpieczenia przed nieprawidłowymi ruchami
Program tworzy plik zapisu save.txt w folderze gry
