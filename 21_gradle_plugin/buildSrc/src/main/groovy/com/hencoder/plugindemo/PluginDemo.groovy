package com.hencoder.plugindemo

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginDemo implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        def extension = project.extensions.create('hencoder', ExtensionDemo)
        project.afterEvaluate {
            println "Hello ${extension.name}!"
        }
        def transform = new TransformDemo()
        def baseExtension = project.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(transform)
    }
}
