# Aufgabe 1 Domänenmodell Vehicle

## Lernziele

- Stereotyp Value Object verstehen und anwenden können
- Stereotyp Root Entity verstehen und anwenden können
- Fundament des Entities Ring / Domain Hexagon verstehen

## Aufgabe 1.1 Grundstruktur Root Entity Vehicle
- Implementiere die in der Tabelle aufgeführten Domänenobjekte des Domänenmodells der Root Entity Vehicle (siehe Abb. 1)  
- Erstelle das Package <i>vehicle.domain.model</i> und lege die Domänenobjekte in diesem Package ab
- Implementiere die im folgenden aufgeführten Validierungsregeln in den betroffenen Domänenobjekten
- Erstelle einen Unit-Test für jedes Domänenobjekt zum Testen der Objekterzeugung und Validierung

 ![Vehicle Domain Model](../img/vehicle-domain-model.png)
 Abb 1: Vehicle Domain Model

| Domänenobjekt     | Validierungsregel und Verhalten                                                                                                                                                         |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Vehicle           | Die Eigenschaften Vin, LicensePlate und Mileage müssen bei einer initialen Fahrzeuganlage immer vorhanden sein. Das Datum der Kilometerstandsmeldung wird innerhalb der Domäne erzeugt. |
| Vin               | Ein valider Wert muss dem vorgesehenen Pattern folgen.                                                                                                                                  |
| LicensePlate      | Ein valider Wert muss dem vorgesehenen Pattern folgen.                                                                                                                                  |
| Mileage           | Der Kilometerstand muss größer 0 sein.                                                                                                                                                  |
| MileageRecord     | Keine Nullwerte.                                                                                                                                                                        |
| RecordDate        | Kein Nullwert.                                                                                                                                                                          |
| VehicleMasterData | Die Eigenschaften CountryOfManufacture und Equipment müssen bei einer initialen Fahrzeuganlage immer vorhanden sein.                                                                    |
| Equipment         | Keine Nullwerte.                                                                                                                                                                        |
| EquipmentCode     | Ein valider Wert muss dem vorgesehenen Pattern folgen.                                                                                                                                  |
| EquipmentLabel    | Ein valider Wert muss dem vorgesehenen Pattern folgen.                                                                                                                                  |

### Regex Pattern für das Value Object Vin

Beispiele:

- WP0ZZZ99ZTS392155
- WBAOLZ99ZTS349156

 ```java
 "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"
 ```
   
### Regex Pattern für das Value Object LicensePlate
   
Beispiele:

- B-AB 123 
- ES-CD 456

```java
"^[A-Z]{1,3}[a-z]{0,1}[-]{0,1}[A-Z]{0,2}\\s[0-9]{1,5}(\\s){0,1}[A-Z]{0,1}[a-z]{0,2}$"
```

### Regex Pattern für das Value Object CountryOfManufacture

Beispiele:

- US 
- DE

```java
"^[A-Z]{2}$"
```

### Regex Pattern für das Value Object EquipmentLabel

Nur Buchstaben und Leerzeichen sind erlaubt.

```java
"^[A-Za-z\\s]+$"
```

### Regex Pattern für das Value Object EquipmentCode

Beispiele:

- AB1234
- UC7934

```java
"^[A-Z]{2}[0-9]{4}$"
```

## Aufgabe 1.2 Rich Domain Model - Verhalten am Domänenobjekt

Implementiere die Aktualisierung des Kilometerstandes mit Plausibilitätsprüfung. 
Dabei gilt das gleiche, wie bei der Fahrzeuganlage. Das Datum der Kilometerstandsmeldung wird innerhalb der Domäne erzeugt.
Wir möchten aus fachlicher Sicht verhindern, dass Kilometerstandmeldungen rückwirkend durchgeführt werden können.


### Plausibilitätsprüfung für den Kilometerstand

```java
neuer Kilometerstand > zuletzt gemeldeter Kilometerstand
```

## Hilfestellung für die Unit-Tests

### Beispiel-Test für das Value Object Vin

```java
class VinTest {

    private final static List<String> VALID_VIN_LIST = Arrays.asList(
            "KMHDU4ADXAU832403", //2010 Hyundai Elantra
            "1GCHC33N7RJ376544", //1994 Chevrolet C/K 3500
            "2S3TD52V3Y6103456", //2000 Suzuki Esteem
            "1G1ZT51816F264066", //2006 Chevrolet Malibu
            "1GBJK34G32E254979" //2002 Chevrolet Silverado 3500
    );

    private final static List<String> INVALID_VIN_LIST = Arrays.asList(
            null,
            "",
            " ",
            "K 234 Lm",
            "123445667",
            "WERTTZUUKHGH"
    );

    @Test
    void shouldCreateValidVinValueObject() {
        VALID_VIN_LIST.forEach(vin -> assertDoesNotThrow(() -> new Vin(vin)));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidVinValue() {
        INVALID_VIN_LIST.forEach(vin -> assertThrows(IllegalArgumentException.class, () -> new Vin(vin)));
    }
}
```

### Beispiel-Test für das Value Object LicensePlate

```java
public class LicensePlateTest {

    private final static List<String> AUSTRIA_LICENSE_PLATE_LIST = Arrays.asList(
            "A 1 B",
            "X 12 Y",
            "Zz 123 Ab",
            "K 234 Lm",
            "Mn 345 Op",
            "Pq 456 Rst",
            "Uv 567 Wxy",
            "Zz 678 Xyz",
            "Aa 789 Bcd",
            "Ef 890 Ghi"
    );
    private final static List<String> GERMAN_LICENSE_PLATE_LIST = Arrays.asList(
            "EES-EL 0815",
            "EES-EL 815",
            "EES-EL 15",
            "EES-EL 5",
            "EES-L 0815",
            "EES-L 085",
            "EES-L 08",
            "EES-L 5",
            "ES-EL 0815",
            "ES-EL 085",
            "ES-EL 08",
            "ES-EL 0",
            "ES-L 0815",
            "ES-L 085",
            "ES-L 08",
            "ES-L 5",
            "E-EL 0815",
            "E-EL 085",
            "E-EL 08",
            "E-EL 0",
            "E-L 0815",
            "E-L 085",
            "E-L 08",
            "E-L 5");

    @Test
    public void shouldCreateValidEuLicensePlateValueObjects() {
        List<String> inputList = new ArrayList<>();
        inputList.addAll(GERMAN_LICENSE_PLATE_LIST);
        inputList.addAll(AUSTRIA_LICENSE_PLATE_LIST);
        List<LicensePlate> licensePlateList = createLicensePlateValueObjects(inputList);
        assertThat(licensePlateList, everyItem(hasValueInList(inputList)));
    }

    @Test
    public void shouldThrowExceptionForInvalidEuLicensePlateValueObjects() {
        List<String> inputList = new ArrayList<>();
        inputList.addAll(Arrays.asList("123456", "A 1 B C", "EES-EL 0815 123"));
        for (String input : inputList) {
            assertThrows(IllegalArgumentException.class, () -> new LicensePlate(input));
        }
    }

    /**
     * Hamcrest could not handle records, due to this hasProperty("value", inList(stringList()) does not work
     *
     * @param stringList
     * @return
     */
    private Matcher<LicensePlate> hasValueInList(List<String> stringList) {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(LicensePlate licensePlate) {
                return stringList.contains(licensePlate.value());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("value should be in the list");
            }
        };
    }

    private List<LicensePlate> createLicensePlateValueObjects(List<String> stringList) {
        return stringList.stream()
                .map(LicensePlate::new)
                .toList();
    }
}
```