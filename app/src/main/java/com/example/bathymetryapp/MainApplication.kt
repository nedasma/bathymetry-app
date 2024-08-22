package com.example.bathymetryapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Starting point of the application, used only for DI purposes
 */
@HiltAndroidApp
class MainApplication : Application()