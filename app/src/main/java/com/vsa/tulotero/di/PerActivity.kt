package com.vsa.tulotero.di

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity