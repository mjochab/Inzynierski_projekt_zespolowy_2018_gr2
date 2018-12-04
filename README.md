# Wstępna dokumentacja aplikacji 
„Wirtualna Uczelnia :)” 

Opis ogólny: <br/>
Aplikacja ma charakter użytkowy. Służy konkretnym użytkownikom, tj. studentom, pracownikom dziekanatu oraz wykładowcom. Zapewnia użytkownikom kontrolę nad funkcjami w Wirtualnej Uczelni, do których mają dostęp.  
Jest ona podzielona na przejrzyste segmenty, dzięki którym jest ona czytelna i bardzo intuicyjna. Cechuje ją prostota. 
Aplikacja ma przede wszystkim zapewnić konkretnym użytkownikom: 
- wyświetlenie ocen, planu zajęć, listy studentów, wykładowców, przedmiotów oraz kierunków. Ponadto edycję ocen, edycję listy studentów, kierunków oraz wybór przedmiotu. 

Aplikacja będzie posiadać dwa tryby pracy:  
Pierwszy – przed zalogowaniem. Jest on identyczny dla każdego typu użytkownika. Widnieje w nim Panel Logowania, za pomocą, którego użytkownik połączy się z funkcjami, do których ma przypisany dostęp. 
Drugi  – po zalogowaniu. W tym segmencie każdy z trzech typów użytkowników posiada inne funkcję. 

Użytkownicy aplikacji:

Student </br>
Pracownik </br>
Wykładowca

Opis uprawnień:<br/>
Student: <br/>
Student w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Student ma możliwość sprawdzenia planu zajęć, ocen, listy przedmiotów. Dodatkowo może wybrać z listy wybrany przedmiot ogólnouczelniany, a także sprawdzić informacje na temat stypendiów. 

Pracownik:<br/>
Pracownik w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Pracownik dziekanatu ma możliwość edycji: ocen, listy studentów, listy zajęć, studentów oraz kierunków. 

Wykładowca: <br/>
Wykładowca w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Wykładowca ma możliwość sprawdzenia planu zajęć, listy studentów, spisu ocen, a także może wykonać edycję tychże ocen. 

Zastosowane technologie:<br/>
Java - oparty na klasach, obiektowy język programowania ogólnego zastosowania. Java jest językiem tworzenia programów źródłowych kompilowanych do kodu bajtowego, czyli postaci wykonywanej przez maszynę wirtualną. Język cechuje się silnym typowaniem. Stanowi ogólnoświatowy standard wykorzystywany przy tworzeniu aplikacji dla urządzeń mobilnych, aplikacji wbudowywanych, gier, zawartości i treści internetowych oraz oprogramowania dla przedsiębiorstw.<br/>
JavaFX – to technologia oprogramowania, która w połączeniu ze środowiskiem Java pozwala tworzyć i wdrażać aplikacje o nowoczesnym wyglądzie oraz bogactwie treści i elementów multimedialnych. Dzięki jej funkcjom \ można zachować dużo większą czytelność kodu. Oprogramowanie JavaFX jest dostępne dla systemów Windows, Mac OS X i Linux. <br/>
MySQL – do realizacji aplikacji został wykorzystany system MySQL. Jest on dostępny bezpłatnie na licencji GPL, dzięki czemu mamy wolność do uruchamiania aplikacji w dowolnym celu, analizowania jej i dostosowywania do własnych potrzeb, a także do rozpowszechniania. Serwer MySQL dostępny jest dla wszystkich popularnych platform systemowych i różnorakich architektur procesorów. Mamy do niego dostęp także w wersji źródłowej, co umożliwia skompilowanie go dla dowolnej innej platformy. Serwer może być posadowiony na dowolnym systemie Unixowym, a także na serwerach Windowsa, czy Solaris. 
