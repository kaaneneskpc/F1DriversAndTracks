data class Circuit(
    val id: Int,
    val name: String,
    val country: String,
    val imageUrl: String,
    val circuitMapUrl: String,
    val length: String,
    val numberOfCorners: Int,
    val numberOfDrsZones: Int,
    val raceDistance: String,
    val numberOfLaps: Int,
    val lapRecord: String,
    val lapRecordHolder: String,
    val firstGrandPrix: Int,
    val description: String,
    val characteristics: List<String>,
    val previousWinners: List<PreviousWinner>,
    val raceSchedule: RaceSchedule,
    val weatherConditions: WeatherInfo
)

data class PreviousWinner(
    val year: Int,
    val driverName: String,
    val team: String
)

data class WeatherInfo(
    val averageTemperature: String,
    val chanceOfRain: String,
    val humidity: String,
    val windSpeed: String,
    val conditions: String
)

data class RaceSchedule(
    val raceDay: String,
    val sessions: List<SessionInfo>
)

data class SessionInfo(
    val name: String,
    val day: String,
    val time: String
) 