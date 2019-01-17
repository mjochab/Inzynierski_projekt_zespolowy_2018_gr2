# Wstępna dokumentacja aplikacji 
„Wirtualna Uczelnia :))” 

Opis ogólny: <br/>
Aplikacja ma charakter użytkowy. Służy konkretnym użytkownikom, tj. studentom, pracownikom dziekanatu oraz wykładowcom. Zapewnia użytkownikom kontrolę nad funkcjami w Wirtualnej Uczelni, do których mają dostęp.  
Jest ona podzielona na przejrzyste segmenty, dzięki którym jest ona czytelna i bardzo intuicyjna. Cechuje ją prostota. 
Aplikacja ma przede wszystkim zapewnić konkretnym użytkownikom: 
- wyświetlenie ocen, listy studentów, wykładowców, oraz przedmiotów. Ponadto edycję ocen, edycję listy studentów oraz wybór przedmiotu. 

Aplikacja będzie posiadać dwa tryby pracy:  
Pierwszy – przed zalogowaniem. Jest on identyczny dla każdego typu użytkownika. Widnieje w nim Panel Logowania, za pomocą, którego użytkownik połączy się z funkcjami, do których ma przypisany dostęp. 
Drugi  – po zalogowaniu. W tym segmencie każdy z trzech typów użytkowników posiada inne funkcję. 

Użytkownicy aplikacji:

Student </br>
Dziekanat </br>
Wykładowca

Opis uprawnień:<br/>
Student: <br/>
Student w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Student ma możliwość sprawdzenia ocen, wybrania przedmiotu ogólnouczelnianego oraz złożenia wniosku stypendialnego.

Dziekanat:<br/>
Dziekanat w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Pracownik dziekanatu ma możliwość edycji: listy studentów, listy wykładowców oraz przegląd złożonych wniosków stypendialnych. 

Wykładowca: <br/>
Wykładowca w aplikacji powinien posiadać możliwość zalogowania się do aplikacji wraz z uprawnieniami dla niego dostępnymi. Po poprawnym przejściu tego etapu, wyświetli mu się środowisko, na którym może wykonywać przydzielone zadania. Wykładowca ma możliwość sprawdzenia listy studentów i spisu ocen, a także może dodać ocenę. 

Zastosowane technologie:<br/>
Java - oparty na klasach, obiektowy język programowania ogólnego zastosowania. Java jest językiem tworzenia programów źródłowych kompilowanych do kodu bajtowego, czyli postaci wykonywanej przez maszynę wirtualną. Język cechuje się silnym typowaniem. Stanowi ogólnoświatowy standard wykorzystywany przy tworzeniu aplikacji dla urządzeń mobilnych, aplikacji wbudowywanych, gier, zawartości i treści internetowych oraz oprogramowania dla przedsiębiorstw.<br/>
JavaFX – to technologia oprogramowania, która w połączeniu ze środowiskiem Java pozwala tworzyć i wdrażać aplikacje o nowoczesnym wyglądzie oraz bogactwie treści i elementów multimedialnych. Dzięki jej funkcjom \ można zachować dużo większą czytelność kodu. Oprogramowanie JavaFX jest dostępne dla systemów Windows, Mac OS X i Linux. <br/>
MySQL – do realizacji aplikacji został wykorzystany system MySQL. Jest on dostępny bezpłatnie na licencji GPL, dzięki czemu mamy wolność do uruchamiania aplikacji w dowolnym celu, analizowania jej i dostosowywania do własnych potrzeb, a także do rozpowszechniania. Serwer MySQL dostępny jest dla wszystkich popularnych platform systemowych i różnorakich architektur procesorów. Mamy do niego dostęp także w wersji źródłowej, co umożliwia skompilowanie go dla dowolnej innej platformy. Serwer może być posadowiony na dowolnym systemie Unixowym, a także na serwerach Windowsa, czy Solaris. </br>
JavaFX Scene Builder - narzędzie umożliwiające użytkownikowi proste tworzenie okien programów oraz wybranych scen od strony wizualnej. Został on wykorzystany przy tworzeniu wyglądu okien oraz przy przypisaniu wykonywanych funkcji do elementów okna. 
