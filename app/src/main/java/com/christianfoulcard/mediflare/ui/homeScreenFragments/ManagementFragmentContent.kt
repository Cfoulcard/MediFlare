package com.christianfoulcard.mediflare.ui.homeScreenFragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.christianfoulcard.mediflare.composables.Buttons.ManagementCardButtons

/**
 * Constructs the content for the ManagementFragment.
 * This composable function defines the user interface components for the management console,
 * including various card buttons. It provides an overview of the available management features.
 */
@Composable
fun ManagementFragmentContent() {

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {


        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85F)
            ) {
              //  Text.FragmentTitle("Hospital Management Console")
                Spacer(Modifier.padding(16.dp))
                ManagementCardButtons("Hospital", "Directory", "Under Development")
                Spacer(Modifier.padding(16.dp))
                ManagementCardButtons("Items Awaiting", "Approval", "No items needing approval")
                Spacer(Modifier.padding(16.dp))
                ManagementCardButtons("", "Settings", "Under Development")
                Spacer(Modifier.padding(16.dp))
                ManagementCardButtons("Broadcast Emergency", "Alerts", "Under Development")
            }
        }
    }
}