package com.vinicius.receitasapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.vinicius.receitasapp.App
import com.vinicius.receitasapp.R
import com.vinicius.receitasapp.data.Recipes
import com.vinicius.receitasapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    //variavel de checagem de permissão
    private var check = false

    private  val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    //recebe resultado da intent de ACTION_PICK
//    private val startImageResult = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            binding.ivAddImage.setImageURI(result.data?.data)
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Pedindo permissão
        initPermission()

        //Configurando o botão para abrir a Intent.ACTION_PICK
//        binding.buttonAddIvGallery.setOnClickListener { openGalleryForImage() }

        binding.addRecipeBtn.setOnClickListener {addReceita()}
    }




    //Abre a intent de action_pick
//    private fun openGalleryForImage() {
//        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//        startImageResult.launch(intent)
//    }

    //checa se existe ou não permissão
    private fun initPermission() {
        if (!getPermissions()) setPermission()
        else check = true
    }


    //Checa se existe permissão
    private fun getPermissions(): Boolean = (ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED)

    private fun setPermission() {
        val permissionList = listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), PERMISSION_CODE)
    }
    //Adicionar Receita
    private fun addReceita(){
        val recipe = Recipes(
            name = binding.nameTil.editText?.text.toString(),
            amount = binding.amountTil.editText?.text.toString(),
            difficulty = binding.difficultyTil.editText?.text.toString(),
            time = binding.timeTil.editText?.text.toString(),
            description = binding.descriptionTil.editText?.text.toString(),
        )
        mainViewModel.insert(recipe)
        Toast.makeText(this, R.string.show_sucess_message, Toast.LENGTH_LONG).show()
        finish()
    }

    private fun errorPermission(){
        Toast.makeText(this, "Não tem permissão", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    errorPermission()
                } else {
                    check = true
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    companion object{
        private const val PERMISSION_CODE = 1
    }
}