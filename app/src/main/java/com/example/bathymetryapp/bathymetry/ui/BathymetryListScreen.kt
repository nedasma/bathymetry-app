package com.example.bathymetryapp.bathymetry.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bathymetryapp.bathymetry.viewmodel.BathymetryListViewModel

/**
 * Displays the list of available scans for a given user.
 */
@Composable
fun BathymetryListScreen(
    modifier: Modifier = Modifier,
    viewModel: BathymetryListViewModel = hiltViewModel()
) {
    val scans = viewModel.scansState.collectAsState(initial = emptyList()).value

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            items(scans) { scan ->
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = modifier
                            .padding(10.dp)
                            .clickable {
                                viewModel.onScanItemClicked()
                            },
                    )
                    Spacer(
                        modifier = modifier
                    )
                    Text(
                        text = "Scan name: ${scan.name}"
                    )
                    Text(
                        text = "Scanning date: ${scan.date}"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BathymetryListScreenPreview() {
    BathymetryListScreen()
}