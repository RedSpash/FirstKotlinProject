package `object`

class Void : Object {
    override fun isSolid(): Boolean {
        return false
    }

    override fun isCollectable(): Boolean {
        return false
    }

    override fun isBreakable(): Boolean {
        return false
    }
}