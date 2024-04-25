package `object`

class Marker : Object {
    override fun isSolid(): Boolean {
        return false
    }

    override fun isCollectable(): Boolean {
        return false
    }

    override fun isBreakable(): Boolean {
        return false
    }

    override fun symbolRepresentation(): String {
        return "o"
    }

}
