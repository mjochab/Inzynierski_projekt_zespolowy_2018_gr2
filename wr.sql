-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Lis 2018, 16:49
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
-- Baza danych: `wr`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dziekanat`
--

CREATE TABLE `dziekanat` (
  `id_pracownika` int(11) NOT NULL,
  `haslo` text COLLATE utf8_polish_ci NOT NULL,
  `imie` text COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` text COLLATE utf8_polish_ci NOT NULL,
  `PESEL` bigint(20) NOT NULL,
  `email` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `dziekanat`
--

INSERT INTO `dziekanat` (`id_pracownika`, `haslo`, `imie`, `nazwisko`, `PESEL`, `email`) VALUES
(1, 'abc', 'Adam', 'Pater', 12345678901, 'adampater@gmail.com'),
(2, 'abcabc', 'Michał', 'Hak', 98765432101, 'michalhak@gmail.com'),
(3, 'abcabcabc', 'Jerzy', 'Kolejka', 96967564610, 'jerzyk@gmai.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `id_studenta` int(11) NOT NULL,
  `haslo` text COLLATE utf8_polish_ci NOT NULL,
  `imie` text COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` text COLLATE utf8_polish_ci NOT NULL,
  `nr_indeksu` int(11) NOT NULL,
  `PESEL` bigint(20) NOT NULL,
  `adres` text COLLATE utf8_polish_ci NOT NULL,
  `email` text COLLATE utf8_polish_ci NOT NULL,
  `kierunek_studiow` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`id_studenta`, `haslo`, `imie`, `nazwisko`, `nr_indeksu`, `PESEL`, `adres`, `email`, `kierunek_studiow`) VALUES
(1, 'abc', 'Mateusz', 'Jarecki', 9606446, 96060502515, 'Legnica', 'matijareczki@gmail.com', 'Informatyka'),
(2, 'abcbca', 'Krzysztof', 'Jarzyna', 9606442, 96060502510, 'Szczecin', 'szefws@gmail,com', 'Informatyka i Ekonometria'),
(3, 'abcbbbc', 'Paweł', 'Krzywy', 9606356, 96060556567, 'Rzeszów', 'pabloka@gmail.com', 'Informatyka');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownik`
--

CREATE TABLE `uzytkownik` (
  `id` int(11) NOT NULL,
  `login` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `haslo` text CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wykladowca`
--

CREATE TABLE `wykladowca` (
  `id_wykladowca` int(11) NOT NULL,
  `haslo` text COLLATE utf8_polish_ci NOT NULL,
  `imie` text COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` text COLLATE utf8_polish_ci NOT NULL,
  `adres` text COLLATE utf8_polish_ci NOT NULL,
  `wiek` bigint(20) NOT NULL,
  `email` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wykladowca`
--

INSERT INTO `wykladowca` (`id_wykladowca`, `haslo`, `imie`, `nazwisko`, `adres`, `wiek`, `email`) VALUES
(1, 'abcabc', 'Jacenty', 'Puszka', 'Rzeszów', 56, 'jacenty@gmail,com'),
(2, 'abcbcabca', 'Filip', 'Kusto', 'Rzeszów', 45, 'fifikusto@gmail.com'),
(3, 'abcabcabcabc', 'Andrzej', 'Dudek', 'Rzeszów', 34, 'andrzejpr@gmail.com');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `dziekanat`
--
ALTER TABLE `dziekanat`
  ADD PRIMARY KEY (`id_pracownika`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_studenta`);

--
-- Indexes for table `uzytkownik`
--
ALTER TABLE `uzytkownik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wykladowca`
--
ALTER TABLE `wykladowca`
  ADD PRIMARY KEY (`id_wykladowca`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `dziekanat`
--
ALTER TABLE `dziekanat`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `student`
--
ALTER TABLE `student`
  MODIFY `id_studenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `wykladowca`
--
ALTER TABLE `wykladowca`
  MODIFY `id_wykladowca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
