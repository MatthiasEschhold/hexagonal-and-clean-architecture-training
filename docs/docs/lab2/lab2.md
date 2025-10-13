# Aufgabe 2 Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Stereotyp Use Case Input Port verstehen und anwenden können
- Stereotyp Use Case Output Port verstehen und anwenden können
- Stereotyp Interactor verstehen und anwenden können
- Aufgaben des Use Cases Ring / Application Hexagon verstehen

## Auflösen von Abhängigkeiten

Abhängigkeiten zwischen Klassen, wie beispielsweise Interactor und Use Case Output Port, werden durch Dependency Injection 
(konkret mittels Constructor Injection) aufgelöst. In der Demo-Anwendung ist hierfür ein parametrisierter Konstruktor erforderlich. 
Es wird weiterhin angenommen, dass ein Framework oder eine Bibliothek einen Injector bereitstellt 
und die Konstruktor-basierte Injizierung der Abhängigkeiten übernimmt. Die Funktionsfähigkeit ist in der Demo-Anwendung nicht notwendig.

Alternativ zur Dependency Injection kann auch das Factory Pattern verwendet werden.

Diese Regelung gilt für alle Übungsaufgaben ab Aufgabe 2.

## Aufgabe 2.0 Basisstruktur des Use Cases Ring anlegen

- Erstelle das Package _vehicle.usecase.in_
- Erstelle das Package _vehicle.usecase.out_
- Erstelle das Package _vehicle.usecase.interactor_

## Aufgabe 2.1 Anwendungsfall Fahrzeug anlegen

- Erstelle die notwendigen ein- und ausgehenden Use Cases für die Fahrzeuganlage
  - Entscheide dich für einen Use-Case-Schnitt (mit Begründung)
- Erstelle den Use Case Interactor des Anwendungsfalls "Fahrzeug anlegen"
- Leg die Klassen in die entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor
  - Hier wir die Verwendung einer Mocking-Library, wie z.B. [mockito](https://site.mockito.org/), notwendig

### Schnittstellenbeschreibung Fahrzeug anlegen 

| Schnittstellenelement | Domänenobjekte             |
|-----------------------|----------------------------|
| Parameter             | Vin, LicensePlate, Mileage |
| Rückgabe              | Vehicle                    |

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Abfrage der Fahrzeugstammdaten bei einem externen Service anhand der Vin
- Erstellung des Fahrzeugs und der intialen Kilometerstandsmeldung
- Speichern des Fahrzeugs

> Scope beachten! Use Cases Ring!

## Aufgabe 2.2 Anwendungsfall Kilometerstand aktualisieren

- Erstelle die notwendigen ein- und ausgehenden Use Case für die Kilometerstandaktualisierung
  - Entscheide dich für einen Use-Case-Schnitt (mit Begründung)
- Erstelle den Use Case Interactor des Anwendungsfalls
- Leg die Klassen in die entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor
  - Hier wir die Verwendung einer Mocking-Library, wie z.B. [mockito](https://site.mockito.org/), notwendig

### Schnittstellenbeschreibung Kilometerstand aktualisieren

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin, Mileage             |
| Rückgabe              | void                     |

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Auslesen des Fahrzeugs aus der Datenbank anhand der Vin 
- Plausibilitätsprüfung der Kilometerstandsmeldung
- Aktualisierung des Kilometerstands
- Speichern des Fahrzeugs

## Aufgabe 2.3 Erweiterung des Anwendungsfalls Fahrzeug anlegen um die Diebstahlprüfung

### Beschreibung

- Bei der Fahrzeuganlage ist eine Diebstahlprüfung durchzuführen
- Die Diebstahlprüfung besteht aus Risikobewertung und Abfrage des Diebstahlstatus 
- Risikobewertung: Welches Risiko besteht, dass das Fahrzeug geklaut sein könnte
- Abfrage des Diebstahlstatus: Abfrage des Diebstahlstatus anhand der Vin bei Interpol
- Ist die Diebstahlprüfung negativ, wird das Fahrzeug, wie unter 2.1 beschrieben, angelegt
  
### Diebstahlprüfung und Risikobewertung

#### Ermittlung des RiskScore

| Risikofaktor                                              | Beschreibung des Risikofaktor                                                                                                              | Bewertung des Risikofaktor<br> (Risk Score Points) |
|-----------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| Hatte das Fahrzeug einen nachvollziehbaren Grenzübergang? | - Herstellungsland != Land der Registrierung<br> - Land der Registrierung wird anhand des Kennzeichen ermitteln                            | +10                                                |
| Ist das Fahrzeug in einem Risikoland angemeldet?          | - Liste von Risikoländer wird von einem externen Service bereitgestellt<br> - Land der Registrierung wird anhand des Kennzeichen ermitteln | +20                                                |
| Beide Risikofaktoren treffen zur gleichen Zeit zu?        | -                                                                                                                                          | +30                                                |

#### Anwendungsfall-spezifische Regel "Risk Score >=50"

**_WENN_** der **RiskScore >= 50** ist, **_DANN_** führe eine Diebstahlstatusabfrage bei Interpol durch.

### Aufgabe

- Führe die notwendigen ein- und ausgehende Use Cases ein
  - Entscheide dich für einen Use-Case-Schnitt (mit Begründung)
- Erstelle das Package _vehicle.domain.service_ und erstelle den Domain Service für die Ermittlung des RiskScore
  - Welche neuen Domänenobjekte werden benötigt und wie können diese im Package-Baum eingeordnet werden?
  - Es ist alles erlaubt: Umbenennen, verschieben, neues Packages, etc.
- Erweitere den Unit-Test für den Interactor des Anwendungsfalls "Fahrzeug anlegen"
- Schreibe einen Unit-Test für den Domain Service für die Ermittlung des RiskScore

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Ermittlung des Risikoscore
- Auswertung des Risikoscore und bei Bedarf Abfrage des Diebstahlstatus
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
- Erstellung des Fahrzeugs und der initialen Kilometerstandsmeldung
- Speichern des Fahrzeugs

### Externe Schnittstellen

#### Schnittstellenbeschreibung externer Service für Risikoländer

| Schnittstellenelement | Domänenobjekte    |
|-----------------------|-------------------|
| Parameter             | Keine             |
| Rückgabe              | List(RiskCountry) |

#### Schnittstellenbeschreibung Abfrage des Diebstahlstatus bei Interpol

| Schnittstellenelement | Domänenobjekte |
|-----------------------|----------------|
| Parameter             | Vin            |
| Rückgabe              | TheftStatus    |

##### Response der Abfrage des Diebstahlstatus

```java
public TheftStatusRequestResponse {
    private String vin;
    private boolean isStolen;
}
```

### Methode zur Ermittlung des Registrierungsland anhand des Kennzeichens

Nutze diesen Domain Service, der viel Magie enthält, zur Ermittlung des Registrierungslandes anhand des Kennzeichens.

```java
public class DetectRegistrationCountryService {

    public CountryCode detect(LicensePlate licensePlate) {
        return new CountryCode("DE");
    }
}

```