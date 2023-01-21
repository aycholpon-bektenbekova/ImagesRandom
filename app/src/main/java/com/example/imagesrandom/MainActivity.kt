package com.example.imagesrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.imagesrandom.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var images = arrayListOf(
        "https://www.freepnglogos.com/uploads/animals-png/animals-jungle-theme-day-camp-shac-15.png",
        "https://static.wixstatic.com/media/2cd43b_2373b379948d4e0cb910c593f7edb96e~mv2.png/v1/fill/w_637,h_800,al_c,q_90,enc_auto/2cd43b_2373b379948d4e0cb910c593f7edb96e~mv2.png",
        "https://i.pinimg.com/736x/a6/ef/14/a6ef147d7f1ebe2f41b6155f1fc5958a.jpg",
        "https://w7.pngwing.com/pngs/133/654/png-transparent-dog-tiger-lion-animal-forest-animals-meeting-animals-illustration-other-cat-like-mammal-carnivoran.png",
        "https://e7.pngegg.com/pngimages/775/408/png-clipart-cartoon-animal-cartoon-animal-photography-wildlife-thumbnail.png"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickers()
    }

    fun clickers() {
        with(binding){
            btnSubmit.setOnClickListener {
                if (Patterns.WEB_URL.matcher(etUrl.toString()).matches()){
                    images.add(etUrl.toString())
                } else {
                    Toast.makeText(this@MainActivity,getString(R.string.not_image), Toast.LENGTH_SHORT).show()
                }
                etUrl.text.clear()
            }

            btnRandom.setOnClickListener {
                Glide.with(this@MainActivity).load(Random.nextInt(images.size)).into(img)
            }
        }
    }
}