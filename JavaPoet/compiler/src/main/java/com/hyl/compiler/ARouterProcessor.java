package com.hyl.compiler;

import java.util.Set;
import java.util.prefs.AbstractPreferences;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;


public class ARouterProcessor extends AbstractProcessor {

    private Elements  elementTools;

    private Types types;

    private Messager messager;



    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        return false;
    }
}
