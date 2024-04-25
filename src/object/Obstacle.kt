package `object`

class Obstacle : Object {
    override fun isSolid(): Boolean {
        return true
    }

    override fun isCollectable(): Boolean {
        return false
    }

    override fun isBreakable(): Boolean {
        return true
    }

    override fun symbolRepresentation(): String {
        return "X"
    }
}