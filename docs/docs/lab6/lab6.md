# Aufgabe 6 Automatiserte Governance mittels Fitness Functions für strukturelle Qualität

## Lernziele

- Strukturtest in der Clean Architecture verstehen und anwenden
- ArchUnit als leichtgewichtiges Tool für Fitness Functions der strukturellen Qualität
- 
## Aufgabe 5.0 Fachliche Modularisierung

- Betrachte die Module GarageOrder und SpareParts

## Aufgabe 5.1 Anwendungsfall Werkstattauftrag anlegen

- Für die Anlage eines Werkstattauftrags im Modul _GarageOrder_ werden die _Vin_, 
das _Kennzeichen (LicensePlate)_ und der aktuelle _Kilometerstand (Mileage)_ des Fahrzeugs benötigt
- Die Abfrage muss anhand des _Kennzeichens_ oder der _Fahrgestellnummer_ möglich sein
- Implementiere ein Muster deiner Wahl, um die Abhängigkeit zwischen dem Domain Module 
_GarageOrder_ und dem Domain Module  _Vehicle_ zu implementieren

### Schnittstellenbeschreibung Fahrzeugdaten abfragen

| Schnittstellenelement | Domänenobjekte |
|-----------------------|---------------|
| Parameter             | Vin           |
| Rückgabe              | VehicleData   |


| Schnittstellenelement | Domänenobjekte          |
|-----------------------|-------------------------|
| Parameter             | LicensePlate            |
| Rückgabe              | VehicleData             |

#### Fahrzeugdaten die im Werkstattauftrag benötigt werden

```java
VehicleData {
    licensePlate: String
    vin: String
    mileage: double        
}
```

## Aufgabe 5.2 Anwendungsfall Fahrzeugstammdaten abfragen

- Die Ersatzteileverwaltung (Modul _SpareParts_) benötigt Fahrzeugstammdaten
- Die Abfrage muss anhand der _Fahrgestellnummer_ möglich sein
- Implementiere ein Muster deiner Wahl, um die Abhängigkeit zwischen dem Domain Module
  _SpareParts_ und dem Domain Module _Vehicle_ zu implementieren

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte    |
|-----------------------|-------------------|
| Parameter             | Vin               |
| Rückgabe              | VehicleMasterData |

## Aufgabe 5.3 Weitere Muster für Abhängigkeiten zwischen Domain Modules

- Diskutiere in der Gruppe oder analysiere für dich, wann ein _Shared Output Adapter Pattern_ oder _Supporting Service Pattern_ eine gute alternative sein kann

Optional:
- Implementiere die Szenarien 5.1 und 5.2 mit einem  _Shared Output Adapter Pattern_
- Implementiere die Szenarien 5.1 und 5.2 mit einem _Supporting Service Pattern_