package com.example.feature_calculation.calculation.result

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


import com.example.core_ui.BaseScreen
import com.example.core_ui.ButtonsPanel
import com.example.core_ui.PADDING
import com.example.feature_calculation.calculation.CalculationViewModel
import com.example.feature_calculation.calculation.ui.DepositView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    viewModel: CalculationViewModel,
    onBack: () -> Unit,
) {
    val context = LocalContext.current

    val deposit = viewModel.calculateResult()

    BaseScreen(
        title = "Результат",
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
                            viewModel.save(deposit)
                            Toast.makeText(context, "Сохранено", Toast.LENGTH_SHORT).show()
                            onBack()
                        }
                    ) {
                        Text("Сохранить")
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onBack()
                        }) {
                        Text("К первому шагу")
                    }
                }
            }
        }
    ) {
        if (deposit != null) {
            DepositView(deposit)
        }
    }
}