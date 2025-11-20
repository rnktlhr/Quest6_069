package viewmodel

import androidx.compose.runtime.MutableState
import com.example.praktikum6.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SiswaViewModel {
    class SiswaViewMode : viewmodel(){
        private val _statusUI = MutableStateFlow(Siswa())
        val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()
    }
}