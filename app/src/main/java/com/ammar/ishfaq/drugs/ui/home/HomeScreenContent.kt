package com.ammar.ishfaq.drugs.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.ammar.ishfaq.drugs.models.drugs.AssociatedDrug
import com.ammar.ishfaq.drugs.models.drugs.Drugs

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    msg: Drugs,
) {

    var selectedDrug by remember { mutableStateOf<AssociatedDrug?>(null) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            msg.problems.forEach { problem ->
//                Text(
//                    text = "Problem: ${
//                        problem.diabetes?.firstOrNull()?.let { "Diabetes" } ?: "Unknown"
//                    }",
//                    style = androidx.compose.material3.MaterialTheme.typography.headlineSmall
//                )
//                VerticalSpacer(size = 8)

                // Display medications
                problem.diabetes.forEach { diabetes ->
                    diabetes.medications.forEach { medication ->
                        medication.medicationsClasses.forEach { medicationClass ->
                            medicationClass.className.forEach { className ->

                                className.associatedDrug.forEach { drug ->
                                    DrugCard(drug) { clickedDrug ->
                                        selectedDrug = clickedDrug
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))

                                }

                                className.associatedDrug2.forEach { drug ->
                                    DrugCard(drug) { clickedDrug ->
                                        selectedDrug = clickedDrug
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))

                                }
                            }
                            medicationClass.className2.forEach { className ->

                                className.associatedDrug.forEach { drug ->
                                    DrugCard(drug) { clickedDrug ->
                                        selectedDrug = clickedDrug
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))

                                }

                                className.associatedDrug2.forEach { drug ->
                                    DrugCard(drug) { clickedDrug ->
                                        selectedDrug = clickedDrug
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))

                                }
                            }
                        }
                    }
                }

            }
        }
        selectedDrug?.let {
            DrugDetailsDialog(drug = it) {
                selectedDrug = null
            }
        }
    }
}

@Composable
fun DrugCard(drug: AssociatedDrug, onClick: (AssociatedDrug) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("drug_item")
            .clickable { onClick(drug) },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = drug.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Dose: ${drug.dose}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Strength: ${drug.strength}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun DrugDetailsDialog(drug: AssociatedDrug, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        },
        text = {
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Drug Details",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Name: ${drug.name}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Strength: ${drug.strength}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Dose: ${drug.dose.ifEmpty { "Not Specified" }}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    )
}
