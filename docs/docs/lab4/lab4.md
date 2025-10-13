# Aufgabe 4 Weitere Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Strategien für den Use-Case-Schnitt verstehen und anwenden können
- Erfahren, wie das Modul in der Clean Architecture wächst und erweitert wird

## Aufgabe 4.0 Mapping Strategie

- Verwende die Two-Way oder One-Way Mapping Strategie für das Mapping zwischen den Datentransferobjekten und den Domänenobjekten
- Betrachte beide Aufgaben und entscheide dich für einen Use-Case-Schnitt. Halte in Stichworten fest, wieso du dich für diesen Schnitt entschieden hast.

## Aufgabe 4.1 Anwendungsfall Fahrzeug lesen für das eigene Frontend

- Das Frontend benötigt Fahrzeugdaten für die Anzeige
-  Implementiere den Anwendungsfall mit Use Cases, Interactor, Interfaces Adapters, Mappings und Datentransferobjekten


### Schnittstellenbeschreibung Anwendungsfall Fahrzeug lesen

| Schnittstellenelement | Domänenobjekte         |
|-----------------------|------------------------|
| Parameter             | Vin                    |
| Rückgabe              | Vehicle     |

### Ablauf des Anwendungsfalls

- Abfrage des Fahrzeugs anhand der Vin

## Aufgabe 4.2 Anwendungsfall Fahrzeugstammdaten lesen für externe Konsumenten

- Das System _Ersatzteileverwaltung_ (_Spare Parts Management_) benötigt Fahrzeugstammdaten für Ersatzteilefindung und -bestellung.
- Implementiere den Anwendungsfall mit Use Cases, Interactor, Interfaces Adapters, Mappings und

### Schnittstellenbeschreibung Fahrzeugstammdaten lesen

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin                      |
| Rückgabe              | Vehicle Master Data      |

### Ablauf des Anwendungsfalls
- Abfrage der Fahrzeugstammdaten anhand der Vin
