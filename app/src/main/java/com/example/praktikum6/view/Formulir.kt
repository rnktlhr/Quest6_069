@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.praktikum6.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable


@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-Laki", "Perempuan"),
    onSubmitBtnClick : () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        {
            TopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors
                    (colorResource(id = R.color.teal_700))
            )
        }

    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {},
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(20.dp)
                    .width(250.dp), thickness = Thickness, color = Color.Red
            )
            Row {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = false,
                            onClick = { item }
                        )
                        Text(text = item)
                    }
                }
            }

        }
    }
}