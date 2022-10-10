package com.miguelgallardocastillo.proyectoubicaciones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miguelgallardocastillo.proyectoubicaciones.databinding.ViewUbicacionBinding


class UbicacionesAdapter (private val ubicaciones: List<Ubicacion>, private val UbicacionClickedListener: (Ubicacion) -> Unit ) : RecyclerView.Adapter<UbicacionesAdapter.ViewHolder>() {


    companion object{
        const val ACTION_VIEW = "ubicación seleccionada"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_ubicacion, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ubicacion = ubicaciones[position]
        holder.bind(ubicacion)
        holder.itemView.setOnClickListener{
            UbicacionClickedListener(ubicacion)
        }
    }

    override fun getItemCount(): Int {
        return ubicaciones.size
    }

    class ViewHolder (private val view: View): RecyclerView.ViewHolder(view){

        //Guardamos en una variable el binding de esta vista para acceder a los elementos.
        val binding = ViewUbicacionBinding.bind(view)

        fun bind (ubicacion : Ubicacion){
            Glide.with(binding.imagen).load(ubicacion.imagen).into(binding.imagen)
            binding.nombreUbicacion.text = ubicacion.nombre
        }
    }



}