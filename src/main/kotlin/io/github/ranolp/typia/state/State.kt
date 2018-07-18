package io.github.ranolp.typia.state

data class State(val name: String, val id: Int) {
    val bitId = 1 shl id
}
