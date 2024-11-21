package com.example.ucp1_101

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var kotaasal by remember { mutableStateOf("") }
    var kotatujuan by remember { mutableStateOf("") }
    var tanggalkeberangkatan by remember { mutableStateOf("") }
    var tanggalkedatangan by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    val dataKelas = listOf("Ekonomi", "Bisnis")

    var confKotaasal by remember { mutableStateOf("") }
    var confKotatujuan by remember { mutableStateOf("") }
    var confTanggalkeberangkatan by remember { mutableStateOf("") }
    var confTanggalkedatangan by remember { mutableStateOf("") }
    var confKelas by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = kotaasal,
            onValueChange = { kotaasal = it },
            label = { Text(text = "Kota Asal") },
            placeholder = { Text(text = "Isi kota asal anda") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = kotatujuan,
            onValueChange = { kotatujuan = it },
            label = { Text(text = "Kota Tujuan") },
            placeholder = { Text(text = "Isi kota tujuan anda") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = tanggalkeberangkatan,
            onValueChange = { tanggalkeberangkatan = it },
            label = { Text(text = "Tanggal Keberangkatan") },
            placeholder = { Text(text = "Isi tanggal keberangkatan anda") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            value = tanggalkedatangan,
            onValueChange = { tanggalkedatangan = it },
            label = { Text(text = "Tanggal Kedatangan") },
            placeholder = { Text(text = "Isi tanggal kedatangan anda") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            dataKelas.forEach { selectedKelas ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = kelas == selectedKelas,
                        onClick = { kelas = selectedKelas }
                    )
                    Text(text = selectedKelas)
                }
            }
        }

        Button(
            onClick = {
                confKotaasal = kotaasal
                confKotatujuan = kotatujuan
                confTanggalkeberangkatan = tanggalkeberangkatan
                confTanggalkedatangan = tanggalkedatangan
                confKelas = kelas
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Simpan")
        }

        // Tampilkan data yang disimpan
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            TampilData(Param = "Kota Asal", Argu = confKotaasal)
            TampilData(Param = "Kota Tujuan", Argu = confKotatujuan)
            TampilData(Param = "Tanggal Keberangkatan", Argu = confTanggalkeberangkatan)
            TampilData(Param = "Tanggal Kedatangan", Argu = confTanggalkedatangan)
            TampilData(Param = "Kelas", Argu = confKelas)
        }
    }
}

@Composable
fun TampilData(Param: String, Argu: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = Param, modifier = Modifier.weight(1f))
        Text(text = ":", modifier = Modifier.weight(0.1f))
        Text(text = Argu, modifier = Modifier.weight(2f))
    }
}


