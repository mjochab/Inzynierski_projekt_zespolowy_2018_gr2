-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Sty 2019, 21:29
-- Wersja serwera: 10.1.28-MariaDB
-- Wersja PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `wu`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dziekanat`
--

CREATE TABLE `dziekanat` (
  `id_pracownika` int(11) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `dziekanat`
--

INSERT INTO `dziekanat` (`id_pracownika`, `imie`, `nazwisko`, `haslo`, `pesel`) VALUES
(1, 'Justyna', 'Kara', 'abc', 89010256743),
(2, 'Janina', 'Dyba', 'abc', 78015566743),
(3, 'Michalina', 'Kontakt', 'abc', 77121256743),
(4, 'Katarzyna', 'Sztuka', 'abc', 89060279811),
(5, 'Urszula', 'Wanio', 'abc', 66040602517);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `oceny`
--

CREATE TABLE `oceny` (
  `id_oceny` int(11) NOT NULL,
  `ocena` int(1) NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  `nazwa` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `imie_w` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko_w` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `id_wykladowcy` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `oceny`
--

INSERT INTO `oceny` (`id_oceny`, `ocena`, `nr_indeksu`, `nazwa`, `imie_w`, `nazwisko_w`, `id_wykladowcy`) VALUES
(1, 5, 964646, 'Ekonomia', 'Jacek', 'Dynia', 3),
(2, 4, 964646, 'Matematyka', 'Jan', 'Ciskoj', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty`
--

CREATE TABLE `przedmioty` (
  `id_przedmiotu` int(11) NOT NULL,
  `nazwa` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `id_wykladowcy` int(11) NOT NULL,
  `nr_indeksu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `przedmioty`
--

INSERT INTO `przedmioty` (`id_przedmiotu`, `nazwa`, `id_wykladowcy`, `nr_indeksu`) VALUES
(1, 'Matematyka', 1, 964634),
(3, 'Ekonomia', 4, 964634);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przed_ocen`
--

CREATE TABLE `przed_ocen` (
  `nazwa` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `przed_ocen`
--

INSERT INTO `przed_ocen` (`nazwa`, `ocena`) VALUES
('Ekonomia', 5),
('Ekonomia', 5),
('Matematyka', 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `id_studenta` int(11) NOT NULL,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL,
  `kierunek_s` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `ulica` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nr_domu` varchar(5) COLLATE utf8_polish_ci NOT NULL,
  `kod_p` char(6) COLLATE utf8_polish_ci NOT NULL,
  `miejscowosc` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `nr_tel` int(9) NOT NULL,
  `nr_indeksu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`id_studenta`, `haslo`, `imie`, `nazwisko`, `pesel`, `kierunek_s`, `ulica`, `nr_domu`, `kod_p`, `miejscowosc`, `nr_tel`, `nr_indeksu`) VALUES
(1, 'abc', 'Jan', 'Nowak', 96060502512, 'Informatyka', 'Rolna', '22', '37-232', 'Rzeszow', 697243321, 964646),
(2, 'abc', 'Janusz', 'Akida', 96060552512, 'Matematyka', 'Slowackiego', '1', '37-212', 'Lublin', 666243321, 966746),
(3, 'abc', 'Kamil', 'Maak', 96060502555, 'Ekonometria', 'Poznanska', '14', '35-500', 'Poznan', 687543123, 964611),
(4, 'abc', 'Mateusz', 'Mleczko', 96060662555, 'Ekonometria', 'Lipowa', '12', '22-522', 'Warszawa', 687543857, 964567),
(5, 'abc', 'Adam', 'Person', 96062202555, 'Informatyka', 'Wspolna', '45', '35-600', 'Krakow', 654643123, 964634);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wniosek`
--

CREATE TABLE `wniosek` (
  `id_wniosku` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `nr_indeksu` int(11) NOT NULL,
  `id_pracownika` int(11) DEFAULT NULL,
  `srednia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wniosek`
--

INSERT INTO `wniosek` (`id_wniosku`, `data`, `nr_indeksu`, `id_pracownika`, `srednia`) VALUES
(1, '2018-11-08', 966746, 1, 5.2),
(3, '2018-11-18', 966746, 1, 4.81),
(6, NULL, 964646, NULL, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wykladowca`
--

CREATE TABLE `wykladowca` (
  `id_wykladowcy` int(11) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `pesel` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wykladowca`
--

INSERT INTO `wykladowca` (`id_wykladowcy`, `imie`, `haslo`, `nazwisko`, `pesel`) VALUES
(1, 'Antoni', 'abc', 'Bugaj', 70060502512),
(2, 'Jan', 'abc', 'Ciskoj', 65060222598),
(3, 'Jacek', 'abc', 'Dynia', 70064578512),
(4, 'Mariusz', 'abc', 'Jasny', 77060467512),
(5, 'Tomasz', 'abc', 'Raczek', 7006045321);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `dziekanat`
--
ALTER TABLE `dziekanat`
  ADD PRIMARY KEY (`id_pracownika`);

--
-- Indexes for table `oceny`
--
ALTER TABLE `oceny`
  ADD PRIMARY KEY (`id_oceny`),
  ADD KEY `nr_indeksu` (`nr_indeksu`) USING BTREE,
  ADD KEY `nazwa` (`nazwa`),
  ADD KEY `imie_w` (`imie_w`),
  ADD KEY `nazwisko_w` (`nazwisko_w`),
  ADD KEY `id_wykladowcy` (`id_wykladowcy`),
  ADD KEY `ocena` (`ocena`);

--
-- Indexes for table `przedmioty`
--
ALTER TABLE `przedmioty`
  ADD PRIMARY KEY (`id_przedmiotu`),
  ADD KEY `nr_indeksu` (`nr_indeksu`),
  ADD KEY `nazwa` (`nazwa`),
  ADD KEY `id_wykladowcy` (`id_wykladowcy`);

--
-- Indexes for table `przed_ocen`
--
ALTER TABLE `przed_ocen`
  ADD KEY `nazwa` (`nazwa`),
  ADD KEY `ocena` (`ocena`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_studenta`),
  ADD KEY `nr_indeksu` (`nr_indeksu`) USING BTREE;

--
-- Indexes for table `wniosek`
--
ALTER TABLE `wniosek`
  ADD PRIMARY KEY (`id_wniosku`),
  ADD KEY `nr_indeksu` (`nr_indeksu`),
  ADD KEY `id_pracownika` (`id_pracownika`);

--
-- Indexes for table `wykladowca`
--
ALTER TABLE `wykladowca`
  ADD PRIMARY KEY (`id_wykladowcy`),
  ADD KEY `nazwisko` (`nazwisko`),
  ADD KEY `imie` (`imie`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `dziekanat`
--
ALTER TABLE `dziekanat`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  MODIFY `id_przedmiotu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `student`
--
ALTER TABLE `student`
  MODIFY `id_studenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `wniosek`
--
ALTER TABLE `wniosek`
  MODIFY `id_wniosku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT dla tabeli `wykladowca`
--
ALTER TABLE `wykladowca`
  MODIFY `id_wykladowcy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `oceny`
--
ALTER TABLE `oceny`
  ADD CONSTRAINT `oceny_ibfk_3` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`),
  ADD CONSTRAINT `oceny_ibfk_4` FOREIGN KEY (`nazwa`) REFERENCES `przedmioty` (`nazwa`),
  ADD CONSTRAINT `oceny_ibfk_5` FOREIGN KEY (`imie_w`) REFERENCES `wykladowca` (`imie`),
  ADD CONSTRAINT `oceny_ibfk_6` FOREIGN KEY (`nazwisko_w`) REFERENCES `wykladowca` (`nazwisko`),
  ADD CONSTRAINT `oceny_ibfk_7` FOREIGN KEY (`id_wykladowcy`) REFERENCES `wykladowca` (`id_wykladowcy`);

--
-- Ograniczenia dla tabeli `przedmioty`
--
ALTER TABLE `przedmioty`
  ADD CONSTRAINT `przedmioty_ibfk_1` FOREIGN KEY (`id_wykladowcy`) REFERENCES `wykladowca` (`id_wykladowcy`),
  ADD CONSTRAINT `przedmioty_ibfk_2` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`);

--
-- Ograniczenia dla tabeli `przed_ocen`
--
ALTER TABLE `przed_ocen`
  ADD CONSTRAINT `przed_ocen_ibfk_1` FOREIGN KEY (`nazwa`) REFERENCES `przedmioty` (`nazwa`),
  ADD CONSTRAINT `przed_ocen_ibfk_2` FOREIGN KEY (`ocena`) REFERENCES `oceny` (`ocena`);

--
-- Ograniczenia dla tabeli `wniosek`
--
ALTER TABLE `wniosek`
  ADD CONSTRAINT `wniosek_ibfk_1` FOREIGN KEY (`id_pracownika`) REFERENCES `dziekanat` (`id_pracownika`),
  ADD CONSTRAINT `wniosek_ibfk_2` FOREIGN KEY (`nr_indeksu`) REFERENCES `student` (`nr_indeksu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
