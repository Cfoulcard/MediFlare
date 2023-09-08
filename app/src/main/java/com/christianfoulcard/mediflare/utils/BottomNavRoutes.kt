package com.christianfoulcard.mediflare.utils

/**
 * Enumeration representing the routes for the bottom navigation destinations in the app.
 * Each enum constant corresponds to a specific route string used for navigation.
 *
 * @param route The unique route string associated with each navigation destination.
 */
enum class BottomNavRoutes(val route: String) {
    DASHBOARD("dashboardRoute"),
    PATIENTS("patientsRoute"),
    MANAGEMENT("managementRoute")
}
