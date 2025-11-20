package com.example.praktikum6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6.model.DataJK.JenisK
import com.example.praktikum6.view.FormIsian
import com.example.praktikum6.view.TampilData
import viewmodel.SiswaViewMode


enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    modifier: Modifier,
    viewMode: SiswaViewMode = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang ->
        val uiState = viewMode.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                val konteks = LocalContext.current
                FormIsian(
                    PilihanJK = JenisK.map{id -> konteks.resources.getString(id)},
                    onSubmitBtnClick = {
                        viewMode.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable (route = Navigasi.Detail.name){
                TampilData(
                    onBackBtnClick = {
                        cancelAndBackToFormulirku(navController)
                    }
                )
            }
        }

    }
}

private fun cancelAndBackToFormulirku(
    navController: NavController
){
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}