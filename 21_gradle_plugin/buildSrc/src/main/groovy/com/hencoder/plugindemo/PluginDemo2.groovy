package com.hencoder.plugindemo

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginDemo2 implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        def extension = project.extensions.create('hencoder2', ExtensionDemo)
        project.afterEvaluate {
            println "Hello ${extension.name}!"
        }
    }
}
