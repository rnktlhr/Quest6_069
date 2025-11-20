package com.example.praktikum6

enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,
            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                FormIsian(
                    onSubmitBtnClick = {
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