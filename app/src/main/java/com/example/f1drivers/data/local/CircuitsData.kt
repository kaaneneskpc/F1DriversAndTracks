package com.example.f1drivers.data.local

import Circuit
import PreviousWinner
import RaceSchedule
import SessionInfo
import WeatherInfo

object CircuitsData {
    val circuits = listOf(
        Circuit(
            id = 1,
            name = "Bahrain International Circuit",
            country = "Bahrain",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245035/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Bahrain%20carbon.png",
            length = "5.412 km",
            numberOfLaps = 57,
            lapRecord = "1:31.447",
            lapRecordHolder = "Pedro de la Rosa (2005)",
            firstGrandPrix = 2004,
            description = "The Bahrain International Circuit has been the home of Formula 1 in the Middle East since 2004. Known for its unique desert setting and challenging layout, the track features long straights and tight corners that test both driver and machine.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Bahrain_Circuit.png",
            numberOfCorners = 15,
            numberOfDrsZones = 3,
            raceDistance = "308.238 km",
            characteristics = listOf(
                "High traction requirements",
                "Heavy braking circuit",
                "High brake wear",
                "Medium downforce",
                "High tire degradation"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Charles Leclerc", "Ferrari"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes"),
                PreviousWinner(2020, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "26°C",
                chanceOfRain = "10%",
                humidity = "45%",
                windSpeed = "15 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "March 2, 2025",
                sessions = listOf(
                    SessionInfo(
                        name = "Practice 1",
                        day = "Thursday",
                        time = "14:30"
                    ),
                    SessionInfo(
                        name = "Practice 2",
                        day = "Thursday",
                        time = "18:00"
                    ),
                    SessionInfo(
                        name = "Practice 3",
                        day = "Friday",
                        time = "15:30"
                    ),
                    SessionInfo(
                        name = "Qualifying",
                        day = "Friday",
                        time = "19:00"
                    ),
                    SessionInfo(
                        name = "Race",
                        day = "Saturday",
                        time = "18:00"
                    )
                )
            )
        ),
        Circuit(
            id = 5,
            name = "Jeddah Corniche Circuit",
            country = "Saudi Arabia",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Saudi%20Arabia%20carbon.png",
            length = "6.174 km",
            numberOfLaps = 50,
            lapRecord = "1:30.734",
            lapRecordHolder = "Lewis Hamilton (2021)",
            firstGrandPrix = 2021,
            description = "The Jeddah Corniche Circuit is the fastest street circuit in Formula 1. Located along the Red Sea, this modern track combines high-speed sections with technical corners, making it one of the most challenging venues on the calendar.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Saudi_Arabia_Circuit.png",
            numberOfCorners = 27,
            numberOfDrsZones = 3,
            raceDistance = "308.45 km",
            characteristics = listOf(
                "Fastest street circuit in F1",
                "High-speed flowing sections",
                "Multiple overtaking opportunities",
                "Night race",
                "Low tire degradation"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2023, "Sergio Perez", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "28°C",
                chanceOfRain = "5%",
                humidity = "65%",
                windSpeed = "12 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "April 20, 2025",
                sessions = listOf(
                    SessionInfo(
                        name = "Practice 1",
                        day = "Thursday",
                        time = "14:30"
                    ),
                    SessionInfo(
                        name = "Practice 2",
                        day = "Thursday",
                        time = "18:00"
                    ),
                    SessionInfo(
                        name = "Practice 3",
                        day = "Friday",
                        time = "14:30"
                    ),
                    SessionInfo(
                        name = "Qualifying",
                        day = "Friday",
                        time = "18:00"
                    ),
                    SessionInfo(
                        name = "Race",
                        day = "Saturday",
                        time = "18:00"
                    )
                )
            )
        ),
        Circuit(
            id = 2,
            name = "Albert Park Circuit",
            country = "Australia",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Australia%20carbon.png",
            length = "5.278 km",
            numberOfLaps = 58,
            lapRecord = "1:20.235",
            lapRecordHolder = "Charles Leclerc (2022)",
            firstGrandPrix = 1996,
            description = "The Albert Park Circuit in Melbourne has been a favorite among fans and drivers since its debut. Set around a picturesque lake, this semi-permanent track offers a perfect blend of speed and technical challenges.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Australia_Circuit.png",
            numberOfCorners = 14,
            numberOfDrsZones = 4,
            raceDistance = "306.124 km",
            characteristics = listOf(
                "Semi-permanent street circuit",
                "Medium downforce",
                "Good overtaking opportunities",
                "Smooth surface",
                "Technical middle sector"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Lando Norris", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Charles Leclerc", "Ferrari"),
                PreviousWinner(2019, "Valtteri Bottas", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "22°C",
                chanceOfRain = "30%",
                humidity = "70%",
                windSpeed = "18 km/h",
                conditions = "Partly Cloudy"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "March 16, 2025",
                sessions = listOf(
                    SessionInfo(
                        name = "Practice 1",
                        day = "Friday",
                        time = "12:30"
                    ),
                    SessionInfo(
                        name = "Practice 2",
                        day = "Friday",
                        time = "16:00"
                    ),
                    SessionInfo(
                        name = "Practice 3",
                        day = "Saturday",
                        time = "12:30"
                    ),
                    SessionInfo(
                        name = "Qualifying",
                        day = "Saturday",
                        time = "16:00"
                    ),
                    SessionInfo(
                        name = "Race",
                        day = "Sunday",
                        time = "15:00"
                    )
                )
            )
        ),
        Circuit(
            id = 4,
            name = "Suzuka Circuit",
            country = "Japan",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Japan%20carbon.png",
            length = "5.807 km",
            numberOfLaps = 53,
            lapRecord = "1:30.983",
            lapRecordHolder = "Lewis Hamilton (2019)",
            firstGrandPrix = 1987,
            description = "Suzuka is one of the most revered circuits in Formula 1. Its unique figure-of-eight layout and challenging corners like the Spoon Curve and 130R have created countless memorable moments in F1 history.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Japan_Circuit.png",
            numberOfCorners = 18,
            numberOfDrsZones = 2,
            raceDistance = "307.471 km",
            characteristics = listOf(
                "Figure-of-eight layout",
                "High downforce circuit",
                "Technical corners",
                "High-speed sections",
                "Challenging in wet conditions"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2019, "Valtteri Bottas", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "20°C",
                chanceOfRain = "40%",
                humidity = "75%",
                windSpeed = "10 km/h",
                conditions = "Variable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "April 6, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "11:30"),
                    SessionInfo("Practice 2", "Friday", "15:00"),
                    SessionInfo("Practice 3", "Saturday", "11:30"),
                    SessionInfo("Qualifying", "Saturday", "15:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 3,
            name = "Shanghai International Circuit",
            country = "China",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/China%20carbon.png",
            length = "5.451 km",
            numberOfLaps = 56,
            lapRecord = "1:32.238",
            lapRecordHolder = "Michael Schumacher (2004)",
            firstGrandPrix = 2004,
            description = "The Shanghai International Circuit is known for its distinctive architecture and challenging layout. The track features one of the toughest corners in F1 - the snail-like Turn 1-2-3 complex that tightens with each turn.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/China_Circuit.png",
            numberOfCorners = 16,
            numberOfDrsZones = 2,
            raceDistance = "305.066 km",
            characteristics = listOf(
                "Long back straight",
                "Unique corner combinations",
                "High tire wear",
                "Good overtaking opportunities",
                "Variable weather conditions"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2019, "Lewis Hamilton", "Mercedes"),
                PreviousWinner(2018, "Daniel Ricciardo", "Red Bull Racing"),
                PreviousWinner(2017, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "18°C",
                chanceOfRain = "35%",
                humidity = "80%",
                windSpeed = "15 km/h",
                conditions = "Overcast"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "March 23, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "11:30"),
                    SessionInfo("Practice 2", "Friday", "15:00"),
                    SessionInfo("Practice 3", "Saturday", "11:30"),
                    SessionInfo("Qualifying", "Saturday", "15:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 6,
            name = "Miami International Autodrome",
            country = "USA",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Miami%20carbon.png",
            length = "5.412 km",
            numberOfLaps = 57,
            lapRecord = "1:29.708",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 2022,
            description = "The Miami International Autodrome, set around the Hard Rock Stadium complex, brings F1 glamour to Florida. The track features 19 corners and three DRS zones, offering plenty of overtaking opportunities.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Miami_Circuit.png",
            numberOfCorners = 19,
            numberOfDrsZones = 3,
            raceDistance = "308.326 km",
            characteristics = listOf(
                "Technical sections",
                "Long straights",
                "Multiple overtaking zones",
                "High temperatures",
                "Challenging surface"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "30°C",
                chanceOfRain = "20%",
                humidity = "85%",
                windSpeed = "8 km/h",
                conditions = "Hot and Humid"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "May 4, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "14:30"),
                    SessionInfo("Practice 2", "Friday", "18:00"),
                    SessionInfo("Practice 3", "Saturday", "14:30"),
                    SessionInfo("Qualifying", "Saturday", "18:00"),
                    SessionInfo("Race", "Sunday", "16:00")
                )
            )
        ),
        Circuit(
            id = 7,
            name = "Imola Circuit",
            country = "Italy",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Emilia%20Romagna%20carbon.png",
            length = "4.909 km",
            numberOfLaps = 63,
            lapRecord = "1:15.484",
            lapRecordHolder = "Lewis Hamilton (2020)",
            firstGrandPrix = 1980,
            description = "The Autodromo Enzo e Dino Ferrari, better known as Imola, is one of F1's most historic venues. This old-school circuit demands respect with its fast corners and minimal run-off areas.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Emilia_Romagna_Circuit.png",
            numberOfCorners = 19,
            numberOfDrsZones = 2,
            raceDistance = "309.049 km",
            characteristics = listOf(
                "Anti-clockwise layout",
                "High-speed corners",
                "Limited overtaking spots",
                "Technical sections",
                "Historic track"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2020, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "21°C",
                chanceOfRain = "45%",
                humidity = "65%",
                windSpeed = "12 km/h",
                conditions = "Variable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "May 18, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 8,
            name = "Monaco Circuit",
            country = "Monaco",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Monaco%20carbon.png",
            length = "3.337 km",
            numberOfLaps = 78,
            lapRecord = "1:12.909",
            lapRecordHolder = "Lewis Hamilton (2021)",
            firstGrandPrix = 1950,
            description = "The Monaco Grand Prix is the jewel in F1's crown. This tight street circuit through the principality is the ultimate test of driving precision, where the barriers are unforgiving and overtaking is a rare art.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Monaco_Circuit.png",
            numberOfCorners = 19,
            numberOfDrsZones = 1,
            raceDistance = "260.286 km",
            characteristics = listOf(
                "Narrow street circuit",
                "Precision driving required",
                "Limited overtaking",
                "Iconic tunnel section",
                "Prestigious event"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Lando Norris", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Sergio Perez", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "23°C",
                chanceOfRain = "25%",
                humidity = "70%",
                windSpeed = "8 km/h",
                conditions = "Sunny"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "May 25, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Thursday", "13:30"),
                    SessionInfo("Practice 2", "Thursday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 9,
            name = "Circuit Gilles Villeneuve",
            country = "Canada",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Canada%20carbon.png",
            length = "4.361 km",
            numberOfLaps = 70,
            lapRecord = "1:13.078",
            lapRecordHolder = "Valtteri Bottas (2019)",
            firstGrandPrix = 1978,
            description = "Located on Montreal's Île Notre-Dame, this circuit is known for its long straights and chicanes. The infamous 'Wall of Champions' has caught out many great drivers over the years.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Canada_Circuit.png",
            numberOfCorners = 14,
            numberOfDrsZones = 3,
            raceDistance = "305.27 km",
            characteristics = listOf(
                "Stop-start nature",
                "Long straights",
                "Heavy braking zones",
                "Wall of Champions",
                "Weather-dependent track"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "George Russell", "Mercedes"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2019, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "22°C",
                chanceOfRain = "35%",
                humidity = "60%",
                windSpeed = "15 km/h",
                conditions = "Partly Cloudy"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "June 15, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 10,
            name = "Circuit de Barcelona-Catalunya",
            country = "Spain",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Spain%20carbon.png",
            length = "4.675 km",
            numberOfLaps = 66,
            lapRecord = "1:18.149",
            lapRecordHolder = "Max Verstappen (2021)",
            firstGrandPrix = 1991,
            description = "A circuit that teams know well from winter testing, Barcelona provides a thorough examination of a car's abilities. Its mix of high and low-speed corners, plus its abrasive surface, tests every aspect of a car's performance.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Spain_Circuit.png",
            numberOfCorners = 16,
            numberOfDrsZones = 2,
            raceDistance = "308.424 km",
            characteristics = listOf(
                "Technical track",
                "High downforce circuit",
                "Abrasive surface",
                "Testing venue",
                "High tire wear"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "25°C",
                chanceOfRain = "15%",
                humidity = "55%",
                windSpeed = "10 km/h",
                conditions = "Sunny"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "June 1, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 11,
            name = "Red Bull Ring",
            country = "Austria",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Austria%20carbon.png",
            length = "4.318 km",
            numberOfLaps = 71,
            lapRecord = "1:05.619",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 1970,
            description = "Set in the Styrian mountains, the Red Bull Ring is a short but intense circuit known for its dramatic elevation changes and fast corners. The track's compact layout and multiple overtaking opportunities make for exciting racing.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Austria_Circuit.png",
            numberOfCorners = 10,
            numberOfDrsZones = 3,
            raceDistance = "306.452 km",
            characteristics = listOf(
                "High altitude circuit",
                "Significant elevation changes",
                "Short lap length",
                "Multiple overtaking spots",
                "High-speed corners"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Lando Norris", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Charles Leclerc", "Ferrari"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "24°C",
                chanceOfRain = "40%",
                humidity = "60%",
                windSpeed = "10 km/h",
                conditions = "Variable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "June 29, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 12,
            name = "Silverstone Circuit",
            country = "Great Britain",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Great%20Britain%20carbon.png",
            length = "5.891 km",
            numberOfLaps = 52,
            lapRecord = "1:27.097",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 1950,
            description = "Silverstone, the home of British motorsport, is one of F1's most historic venues. Known for its high-speed corners like Copse and Maggots-Becketts complex, it's a true test of driver skill and car aerodynamics.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Great_Britain_Circuit.png",
            numberOfCorners = 18,
            numberOfDrsZones = 2,
            raceDistance = "306.198 km",
            characteristics = listOf(
                "High-speed corners",
                "Technical sections",
                "Historic venue",
                "Weather variability",
                "Strong aerodynamic demands"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Lando Norris", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Carlos Sainz", "Ferrari"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "20°C",
                chanceOfRain = "45%",
                humidity = "75%",
                windSpeed = "15 km/h",
                conditions = "Changeable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "July 6, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "16:00")
                )
            )
        ),
        Circuit(
            id = 13,
            name = "Hungaroring",
            country = "Hungary",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Hungary%20carbon.png",
            length = "4.381 km",
            numberOfLaps = 70,
            lapRecord = "1:16.627",
            lapRecordHolder = "Lewis Hamilton (2020)",
            firstGrandPrix = 1986,
            description = "Often compared to Monaco without the barriers, the Hungaroring is a tight and twisty circuit where overtaking is challenging. The track's technical nature and typically hot conditions make it a true test of driver concentration.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Hungary_Circuit.png",
            numberOfCorners = 14,
            numberOfDrsZones = 2,
            raceDistance = "306.63 km",
            characteristics = listOf(
                "Tight and twisty layout",
                "High downforce circuit",
                "Limited overtaking spots",
                "Hot conditions",
                "Technical driving required"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Esteban Ocon", "Alpine")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "28°C",
                chanceOfRain = "20%",
                humidity = "55%",
                windSpeed = "8 km/h",
                conditions = "Hot and Sunny"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "August 3, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 14,
            name = "Spa-Francorchamps",
            country = "Belgium",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Belgium%20carbon.png",
            length = "7.004 km",
            numberOfLaps = 44,
            lapRecord = "1:46.286",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 1950,
            description = "The legendary Spa-Francorchamps is one of F1's most challenging circuits. Home to the famous Eau Rouge-Raidillon complex, the track's mix of long straights and high-speed corners through the Ardennes forest makes it a driver favorite.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Belgium_Circuit.png",
            numberOfCorners = 19,
            numberOfDrsZones = 2,
            raceDistance = "308.052 km",
            characteristics = listOf(
                "Longest circuit on calendar",
                "Elevation changes",
                "Weather unpredictability",
                "High-speed sections",
                "Historic track"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Oscar Piastri", "McLaren"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "19°C",
                chanceOfRain = "60%",
                humidity = "80%",
                windSpeed = "12 km/h",
                conditions = "Unpredictable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "July 27, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 15,
            name = "Zandvoort Circuit",
            country = "Netherlands",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Netherlands%20carbon.png",
            length = "4.259 km",
            numberOfLaps = 72,
            lapRecord = "1:11.097",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 1952,
            description = "The renovated Zandvoort circuit features unique banked corners and a challenging layout through the Dutch coastal dunes. The track's narrow width and flowing nature make it a thrilling challenge for drivers.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Netherlands_Circuit.png",
            numberOfCorners = 14,
            numberOfDrsZones = 2,
            raceDistance = "306.648 km",
            characteristics = listOf(
                "Banked corners",
                "Narrow track",
                "Coastal location",
                "Technical sections",
                "Limited overtaking"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "20°C",
                chanceOfRain = "30%",
                humidity = "75%",
                windSpeed = "20 km/h",
                conditions = "Windy"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "August 31, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 16,
            name = "Monza Circuit",
            country = "Italy",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Italy%20carbon.png",
            length = "5.793 km",
            numberOfLaps = 53,
            lapRecord = "1:21.046",
            lapRecordHolder = "Rubens Barrichello (2004)",
            firstGrandPrix = 1950,
            description = "Known as 'The Temple of Speed', Monza is F1's fastest track. The historic circuit in the Royal Park features long straights and chicanes, making it a unique challenge that rewards both power and precision.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Italy_Circuit.png",
            numberOfCorners = 11,
            numberOfDrsZones = 2,
            raceDistance = "306.72 km",
            characteristics = listOf(
                "Highest average speed",
                "Long straights",
                "Historic venue",
                "Low downforce setup",
                "Heavy braking zones"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Daniel Ricciardo", "McLaren")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "25°C",
                chanceOfRain = "25%",
                humidity = "65%",
                windSpeed = "8 km/h",
                conditions = "Sunny"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "September 7, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "15:00")
                )
            )
        ),
        Circuit(
            id = 17,
            name = "Marina Bay Street Circuit",
            country = "Singapore",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Singapore%20carbon.png",
            length = "4.94 km",
            numberOfLaps = 62,
            lapRecord = "1:35.867",
            lapRecordHolder = "Lewis Hamilton (2018)",
            firstGrandPrix = 2008,
            description = "F1's original night race, the Marina Bay Street Circuit is one of the most physically demanding tracks on the calendar. The humid conditions and relentless nature of the circuit make it a true test of endurance.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Singapore_Circuit.png",
            numberOfCorners = 19,
            numberOfDrsZones = 3,
            raceDistance = "306.28 km",
            characteristics = listOf(
                "Night race",
                "Street circuit",
                "High humidity",
                "Physical challenge",
                "Technical sections"
            ),
            previousWinners = listOf(
                PreviousWinner(2023, "Carlos Sainz", "Ferrari"),
                PreviousWinner(2022, "Sergio Perez", "Red Bull Racing"),
                PreviousWinner(2019, "Sebastian Vettel", "Ferrari")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "30°C",
                chanceOfRain = "40%",
                humidity = "90%",
                windSpeed = "5 km/h",
                conditions = "Hot and Humid"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "October 5, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "17:30"),
                    SessionInfo("Practice 2", "Friday", "21:00"),
                    SessionInfo("Practice 3", "Saturday", "17:30"),
                    SessionInfo("Qualifying", "Saturday", "21:00"),
                    SessionInfo("Race", "Sunday", "20:00")
                )
            )
        ),
        Circuit(
            id = 18,
            name = "Baku City Circuit",
            country = "Azerbaijan",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Azerbaijan%20carbon.png",
            length = "6.003 km",
            numberOfLaps = 51,
            lapRecord = "1:43.009",
            lapRecordHolder = "Charles Leclerc (2019)",
            firstGrandPrix = 2016,
            description = "The Baku City Circuit is one of F1's most unique street circuits. Running through the historic city center and along the Caspian Sea, the track features a mix of tight corners and long straights, including the longest straight in F1.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Azerbaijan_Circuit.png",
            numberOfCorners = 20,
            numberOfDrsZones = 2,
            raceDistance = "306.049 km",
            characteristics = listOf(
                "Street circuit",
                "Longest straight in F1",
                "Narrow sections",
                "High-speed sections",
                "Unpredictable racing"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Sergio Perez", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Sergio Perez", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "22°C",
                chanceOfRain = "15%",
                humidity = "55%",
                windSpeed = "12 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "September 21, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "17:30"),
                    SessionInfo("Practice 2", "Friday", "21:00"),
                    SessionInfo("Practice 3", "Saturday", "17:30"),
                    SessionInfo("Qualifying", "Saturday", "21:00"),
                    SessionInfo("Race", "Sunday", "20:00")
                )
            )
        ),
        Circuit(
            id = 20,
            name = "Circuit of The Americas",
            country = "USA",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/United%20States%20carbon.png",
            length = "5.513 km",
            numberOfLaps = 56,
            lapRecord = "1:36.169",
            lapRecordHolder = "Charles Leclerc (2019)",
            firstGrandPrix = 2012,
            description = "Inspired by some of F1's greatest circuits, COTA combines challenging corners with significant elevation changes. The iconic first sector, with its steep uphill run into Turn 1, is one of modern F1's most distinctive features.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/USA_Circuit.png",
            numberOfCorners = 20,
            numberOfDrsZones = 2,
            raceDistance = "308.405 km",
            characteristics = listOf(
                "Elevation changes",
                "Technical first sector",
                "Multiple overtaking spots",
                "High-speed sections",
                "Modern facilities"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "25°C",
                chanceOfRain = "20%",
                humidity = "60%",
                windSpeed = "15 km/h",
                conditions = "Sunny"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "October 19, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "13:30"),
                    SessionInfo("Qualifying", "Saturday", "17:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 21,
            name = "Autódromo Hermanos Rodríguez",
            country = "Mexico",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Mexico%20carbon.png",
            length = "4.304 km",
            numberOfLaps = 71,
            lapRecord = "1:17.774",
            lapRecordHolder = "Valtteri Bottas (2021)",
            firstGrandPrix = 1963,
            description = "Located at high altitude, the Mexican Grand Prix presents unique challenges for both cars and drivers. The famous stadium section, passing through the Foro Sol baseball stadium, creates one of F1's most atmospheric venues.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Mexico_Circuit.png",
            numberOfCorners = 17,
            numberOfDrsZones = 3,
            raceDistance = "305.354 km",
            characteristics = listOf(
                "High altitude",
                "Long straight",
                "Stadium section",
                "Thin air effects",
                "Technical middle sector"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "22°C",
                chanceOfRain = "15%",
                humidity = "45%",
                windSpeed = "8 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "October 26, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 22,
            name = "Interlagos Circuit",
            country = "Brazil",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Brazil%20carbon.png",
            length = "4.309 km",
            numberOfLaps = 71,
            lapRecord = "1:10.540",
            lapRecordHolder = "Valtteri Bottas (2018)",
            firstGrandPrix = 1973,
            description = "The Autódromo José Carlos Pace, better known as Interlagos, is one of F1's most beloved circuits. Its anti-clockwise layout, elevation changes, and passionate fans create an electric atmosphere for racing.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Brazil_Circuit.png",
            numberOfCorners = 15,
            numberOfDrsZones = 2,
            raceDistance = "305.879 km",
            characteristics = listOf(
                "Anti-clockwise layout",
                "Elevation changes",
                "Weather variability",
                "Good overtaking spots",
                "Technical infield"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "George Russell", "Mercedes"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "24°C",
                chanceOfRain = "40%",
                humidity = "75%",
                windSpeed = "12 km/h",
                conditions = "Variable"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "November 9, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "12:30"),
                    SessionInfo("Qualifying", "Saturday", "16:00"),
                    SessionInfo("Race", "Sunday", "14:00")
                )
            )
        ),
        Circuit(
            id = 23,
            name = "Las Vegas Street Circuit",
            country = "USA",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Las%20Vegas%20carbon.png",
            length = "6.201 km",
            numberOfLaps = 50,
            lapRecord = "1:35.490",
            lapRecordHolder = "Oscar Piastri (2023)",
            firstGrandPrix = 2023,
            description = "Racing down the famous Las Vegas Strip, this new circuit brings F1 glamour to Sin City. The high-speed street circuit features long straights and technical sections, all set against the backdrop of Vegas's iconic landmarks.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Las_Vegas_Circuit.png",
            numberOfCorners = 17,
            numberOfDrsZones = 2,
            raceDistance = "310.05 km",
            characteristics = listOf(
                "Night race",
                "Street circuit",
                "Long straights",
                "Low temperatures",
                "High-speed sections"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "15°C",
                chanceOfRain = "10%",
                humidity = "40%",
                windSpeed = "15 km/h",
                conditions = "Cold"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "November 23, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Thursday", "20:30"),
                    SessionInfo("Practice 2", "Friday", "00:00"),
                    SessionInfo("Practice 3", "Friday", "20:30"),
                    SessionInfo("Qualifying", "Saturday", "00:00"),
                    SessionInfo("Race", "Saturday", "22:00")
                )
            )
        ),
        Circuit(
            id = 24,
            name = "Yas Marina Circuit",
            country = "Abu Dhabi",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Abu%20Dhabi%20carbon.png",
            length = "5.281 km",
            numberOfLaps = 58,
            lapRecord = "1:26.103",
            lapRecordHolder = "Max Verstappen (2021)",
            firstGrandPrix = 2009,
            description = "The season-ending Abu Dhabi Grand Prix takes place at the spectacular Yas Marina Circuit. Racing from day into night under floodlights, the track winds its way around the iconic Yas Hotel and marina.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Abu_Dhabi_Circuit.png",
            numberOfCorners = 16,
            numberOfDrsZones = 2,
            raceDistance = "306.183 km",
            characteristics = listOf(
                "Day-night race",
                "Modern facilities",
                "Technical sections",
                "Long straights",
                "Smooth surface"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2022, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Max Verstappen", "Red Bull Racing")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "27°C",
                chanceOfRain = "5%",
                humidity = "50%",
                windSpeed = "10 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "December 7, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "13:30"),
                    SessionInfo("Practice 2", "Friday", "17:00"),
                    SessionInfo("Practice 3", "Saturday", "14:30"),
                    SessionInfo("Qualifying", "Saturday", "18:00"),
                    SessionInfo("Race", "Sunday", "17:00")
                )
            )
        ),
        Circuit(
            id = 25,
            name = "Lusail International Circuit",
            country = "Qatar",
            imageUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677245034/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Qatar%20carbon.png",
            length = "5.419 km",
            numberOfLaps = 57,
            lapRecord = "1:24.319",
            lapRecordHolder = "Max Verstappen (2023)",
            firstGrandPrix = 2021,
            description = "Originally designed for motorcycle racing, the Lusail International Circuit features a mix of medium and high-speed corners. The floodlit night race presents unique challenges with track temperature and visibility.",
            circuitMapUrl = "https://media.formula1.com/image/upload/f_auto/q_auto/v1677244887/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Qatar_Circuit.png",
            numberOfCorners = 16,
            numberOfDrsZones = 1,
            raceDistance = "308.611 km",
            characteristics = listOf(
                "Night race",
                "Fast flowing corners",
                "High grip levels",
                "Physical challenge",
                "Desert conditions"
            ),
            previousWinners = listOf(
                PreviousWinner(2024, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2023, "Max Verstappen", "Red Bull Racing"),
                PreviousWinner(2021, "Lewis Hamilton", "Mercedes")
            ),
            weatherConditions = WeatherInfo(
                averageTemperature = "25°C",
                chanceOfRain = "5%",
                humidity = "55%",
                windSpeed = "12 km/h",
                conditions = "Clear"
            ),
            raceSchedule = RaceSchedule(
                raceDay = "November 30, 2025",
                sessions = listOf(
                    SessionInfo("Practice 1", "Friday", "14:30"),
                    SessionInfo("Practice 2", "Friday", "18:00"),
                    SessionInfo("Practice 3", "Saturday", "14:30"),
                    SessionInfo("Qualifying", "Saturday", "18:00"),
                    SessionInfo("Race", "Sunday", "18:00")
                )
            )
        )
    )
} 