package hr.helix.kin

import groovy.transform.EqualsAndHashCode

/**
 * Model for job parameters.
 * 
 * @author Miro Bezjak
 * @since 1.0
 */
@EqualsAndHashCode
class Job {

    final String name
    boolean producesConfig = true
    final List<String> inheritFromParents = []
    final Map<String, Object> traits      = [:]

    Job(String name) {
        if (!name) {
            throw new IllegalArgumentException('Job must have valid name')
        }
        this.name = name
    }

    void inherit(String parent) {
        inherit([parent])
    }

    void inherit(String[] parents) {
        inherit(parents as List)
    }

    void inherit(List<String> parents) {
        inheritFromParents.addAll parents
    }

    def propertyMissing(String name, value) {
        traits[name] = value
    }

    def propertyMissing(String name) {
        traits[name]
    }

}
