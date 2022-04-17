package libgdxTemplate.pongClasses

class ScoreCounter {
    var scores = mutableMapOf<String, Int>()

    fun addTeam(team: String) {
        scores[team] = 0
    }

    fun addScore(player: String, howmuch: Int = 1) {
        scores[player] = scores.getOrDefault(player, 0) + howmuch
    }

    fun resetAllScores(to: Int = 0)
    {
        scores.mapKeys { scores[it.key] = to }
    }

}