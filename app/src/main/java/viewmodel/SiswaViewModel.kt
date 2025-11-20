package viewmodel

import androidx.compose.runtime.MutableState
import com.example.praktikum6.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow

class SiswaViewModel {
    class SiswaViewMode : viewmodel(){
        private val _statusUI = MutableStateFlow(Siswa())

    }
}