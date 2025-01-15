


------Fokus-----

skapa löplista för löpare
testa om id finns (i konstruktor)
Ändra ID om felmeddelande


Kolla att ID inte redan finns - ge fel -- KLART, MEN: --Gör detta i konstruktor! + ge fel
--(Avancerat: Kolla vad senaste ID är och tilldela automatiskt ID)

Se över att all funktionalitet är täckt

Filtera på distans -- returnera LIst<String> med aktuella ID
Filtrera på tid -- returnera LIst<String> med aktuella ID


---
Steg 2: Se över fillagring


---------------


Printa detaljer för löprunda genom att ange ID -- KLART
Radera löprunda genom att ange ID -- KLART


Beräkna & tilldela automatiskt

- Record: Medelhastighet enligt formeln: $$ hastighet = {distans(km) \over tid(hrs)} 
- Record: Kilometertid enligt formeln: $$ kilometertid = {tid(min) \over distans(km)}
- Runner: Nytt fitness score
!! - Obs fitness score - om det är första löpturen är värdet 0! <-- lösa genom att dagar sedan senaste löptur = automatiskt 0? Skicka in boolean firstRecord?


TDD-Dagboken! - Under kontroll
- Fitness Score (efter varje löptur), ej <0, endast heltal, Om första rundan är värdet 0
X + Y + Z/A - B/2
X - nuvarande fitness score
Y - distans, km
Z - medelhastighet, km/h
A - kilometertid (min/km)
B - Dagar sedan senaste löptur
 --skicka in nuvarande fitnessscore + record


Test: Beräkna dagar sedan senaste löptur --KLART

Beräkningar, varje löprunda: 
- Medelhastighet km/h --KLART
- km-tid, min/km --KLART

Beräkningar, för alla löprundor:
Total distans -- KLART
Medeldistans -- KLART


Skapa löpare --KLART
Sätt ålder --KLART
Sätt längd --KLART
Sätt vikt --KLART


Skapa löptur --KLART
Sätt ID --IN PROGRESS


Skapa mocklista att mäta mot. --FIXAT, görs i avje test
--Avancerat Filtrera med avseende på distans (ange vilka ID?)
--Avancerat  Filtrera med avseendepå tid (ange vilka ID?)


Sätt distans (km, double)
Sätt tid (H/M/S eller s? svar: användarinmatning/visning i HHMMSS, datalagring i s)
Sätt datum (YY/MM/DD) (med option att automatisk tilldelas om lämnas tomt) --KLART
Sätt automatiskt dagens datum om datum saknas --KLART
--(Avancerat: kasta exception om datum eller tid saknas)

Tidkonvertering, HHMMSS till sekunder --KLART
Tidkonvertering, sekunder till HHMMSS --KLART




OM TESTER - 
God testpraxis: 
- Ett test testar en enda sak
- Enskilda klasser för testklasser
- Beskrivande testnamn
- 



NOTE: Testar inte getters och setters.

