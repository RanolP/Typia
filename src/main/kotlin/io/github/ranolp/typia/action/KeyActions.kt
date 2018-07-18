package io.github.ranolp.typia.action

import io.github.ranolp.typia.keyboard.key.Key

class KeyDownAction(val key: Key) : Action("Key Down", 0)
class KeyUpAction(val key: Key) : Action("Key Up", 1)
class KeyPressAction(val key: Key) : Action("Key Press", 2)
