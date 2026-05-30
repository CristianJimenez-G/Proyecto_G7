package com.example.idatdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ListaComprasActivity : AppCompatActivity() {
    private lateinit var lvProductos :ListView
    private lateinit var tietProducto : TextInputEditText
    private lateinit var btnGuardar : MaterialButton
    private lateinit var tilProducto: textInputLayaout

    private val produtos = mutableListOf<String>()
    private lateinit var productosAdapter : ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_compras)

        lvProductos = findViewById(R.id.lvProductos)
        tietProducto = findViewById(R.id.tietProducto)
        btnGuardar = findViewById(R.id.btnGuardar)


        val productos = mutableListOf("Arroz", "Azucar", "Avena")

        productosAdapter = ArrayAdapter(
            this,

            android.R.layout.simple_list_item_1,
            productos
        )

        lvProductos.adapter = productosAdapter

        btnGuardar.setOnClickListener {
            val producto = tietProducto.text.toString().trim()
            if (producto.isNotEmpty()) {
                producto.add(producto)
                productosAdapter.notifyDataSetChanged()
                tietProducto.text?.clear()
            } else {
                Toast.makeText(this, "Ingrese un producto", Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}