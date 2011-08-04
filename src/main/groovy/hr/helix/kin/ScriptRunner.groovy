package hr.helix.kin

import org.codehaus.groovy.control.CompilerConfiguration

/**
 * @author Miro Bezjak
 * @since 1.0
 */
class ScriptRunner {

    BuildModel run(String input) {
        def script = createShell().parse(input)
        script.run()
        script._model
    }

    /**
     * Create and configure {@link GroovyShell} so that it can parse DSL script.
     */
    GroovyShell createShell() {
        def compiler = new CompilerConfiguration()
        compiler.scriptBaseClass = BuildModelScript.canonicalName

        new GroovyShell(this.class.classLoader, new Binding(), compiler)
    }

}
