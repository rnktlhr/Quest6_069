package com.example.praktikum6.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onBackBtnClick:()->Unit
){
    val items = listOf(
        Pair(stringResource(id = R.string.nama_lengkap), "Contoh Nama"),
        Pair(stringResource(id = R.string.jenis_kelamin), "Lainnya"),
        Pair(stringResource(id = R.string.alamat), "Yogyakarta")
    )
    Scaffold(modifier = Modifier,
        {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.tampil),
                        color = Color.White
                    )},
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(colorResource(id=R.color.teal_700)
                    )
            )
        }) { isiRuang->
        Column(modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
                items.forEach { item ->
                    Column {
                        Text(text = item.first.uppercase(),
                            fontSize = 16.sp)
                        Text(text = item.second,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive, fontSize = 22.sp)
                    }
                    HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
                }