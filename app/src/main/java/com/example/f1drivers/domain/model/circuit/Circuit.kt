data class Circuit(
    val id: Int,
    val name: String,
    val country: String,
    val imageUrl: String,
    val length: String,
    val numberOfLaps: Int,
    val lapRecord: String,
    val lapRecordHolder: String,
    val firstGrandPrix: Int,
    val description: String,
    val circuitMapUrl: String,
    val numberOfCorners: Int,
    val numberOfDrsZones: Int,
    val raceDistance: String,
    val previousWinners: List<PreviousWinner>,
    val characteristics: List<String>,
    val weatherConditions: WeatherInfo,
    val raceSchedule: RaceSchedule
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