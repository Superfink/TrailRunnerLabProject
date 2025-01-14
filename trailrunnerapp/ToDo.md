


------Fokus-----

Beräkningar, varje löprunda: 
- Medelhastighet km/h --KLART
- km-tid, min/km
- Fitness Score (efter varje löptur), ej <0, endast heltal, Om första rundan är värdet 0

X + Y + Z/A - B/2
X - nuvarande fitness score
Y - distans, km
Z - medelhastighet, km/h
A - kilometertid (min/km)
B - Dagar sedan senaste löptur

Beräkningar, för alla löprundor:
Total distans
Medeldistans

Printa detaljer för löprunda genom att ange ID
Radera löprunda genom att ange ID
Filtrera med avseende på distans (ange vilka ID?)
Filtrera med avseendepå tid (ange vilka ID?)

-------


Skapa löpare --KLART
Sätt ålder --KLART
Sätt längd --KLART
Sätt vikt --KLART


Skapa löptur --KLART
Sätt ID --IN PROGRESS

Härnäst:
Skapa mocklista att mäta mot. --IN PROGRESS




Sätt distans (km, double)
Sätt tid (H/M/S eller s? svar: användarinmatning/visning i HHMMSS, datalagring i s)
Sätt datum (YY/MM/DD) (med option att automatisk tilldelas om lämnas tomt) --KLART
Sätt automatiskt dagens datum om datum saknas --KLART
--(Avancerat: kasta exception om datum eller tid saknas)

Tidkonvertering, HHMMSS till sekunder --KLART
Tidkonvertering, sekunder till HHMMSS --KLART




Lägg till löptur i mocklista
Kolla att ID inte redan finns - ge fel
--(Avancerat: Kolla vad senaste ID är och tilldela automatiskt ID)


OM TESTER - 
God testpraxis: 
- Ett test testar en enda sak
- Enskilda klasser för testklasser
- Beskrivande testnamn
- 



NOTE: Testar inte getters och setters.

