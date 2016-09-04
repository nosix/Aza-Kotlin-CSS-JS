package azagroup.kotlin.css

import azagroup.kotlin.css.colors.clr
import kotlin.reflect.KProperty


class ColorPropertyHandler(
		val name: String
) {
	@Suppress("USELESS_CAST")
	operator fun getValue(stylesheet: Stylesheet, property: KProperty<*>)
			= stylesheet.getProperty(name) as Any?

	operator fun setValue(stylesheet: Stylesheet, property: KProperty<*>, value: Any?) {
		stylesheet.setProperty(name, when (value) {
			is Int -> clr(value)
			else -> value
		})
	}
}
