package viewmodel

import android.R
import androidx.compose.runtime.MutableState
import com.example.praktikum6.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel {
    class SiswaViewMode : viewmodel(){
        private val _statusUI = MutableStateFlow(Siswa())
        val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

        fun setSiswa(ls: MutableList<String>) {
            _statusUI.update { statusSaatIni ->
                statusSaatIni.copy(
                    nama = ls[0],
                    gender = ls[1],
                    alamat = ls[2]
                )
            }
        }
    }
}