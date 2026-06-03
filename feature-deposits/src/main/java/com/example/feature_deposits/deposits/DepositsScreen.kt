package com.example.feature_deposits.deposits

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.BaseScreen
import com.example.core_ui.ButtonsPanel
import com.example.core_ui.PADDING
import com.example.feature_deposits.ui.DepositView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DepositsScreen(
    viewModel: DepositsViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val deposits by viewModel.deposits.collectAsState()

    BaseScreen(
        title = "История",
        scrollable = false,
        bottomBar = {
            Column(
                modifier = Modifier
                    .imePadding()
                    .padding(PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(PADDING)
            ) {
                ButtonsPanel {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            viewModel.clear()
                            Toast.makeText(context, "Отчищено", Toast.LENGTH_SHORT).show()
                        }) {
                        Text("Отчистить")
                    }
                }
            }
        }
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(deposits) { item ->
                DepositView(item)
            }
        }
    }
}