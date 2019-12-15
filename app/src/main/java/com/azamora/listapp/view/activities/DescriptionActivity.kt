package com.azamora.listapp.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_app_description_activity.imageView
import kotlinx.android.synthetic.main.list_app_description_activity.longDescriptionTextView
import kotlinx.android.synthetic.main.list_app_description_activity.titleTextView

import com.azamora.listapp.R

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_app_description_activity)

        intent?.extras?.let {
            titleTextView.text = it.getString("title")
            longDescriptionTextView.text = it.getString("description")
            Picasso.get().load(it.getString("image")).placeholder(R.drawable.list_app_placeholder).into(imageView)
        }

    }


}