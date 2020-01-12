package com.benjaminledet.pokedex.ui.pokemon.detail

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.model.Move
import com.benjaminledet.pokedex.data.repository.utils.Status
import com.benjaminledet.pokedex.ui.pokemon.list.PokemonsContainerFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailFragment: Fragment() {

    private val listView: ListView
        get() {
            return listView
        }

    private val viewModel by viewModel<PokemonDetailViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pokemonId.postValue(arguments?.getInt("pokemonId"))

        viewModel.refreshState.observe(viewLifecycleOwner, Observer { refreshState ->
            progressBar.isVisible = refreshState.status == Status.RUNNING
            content.isVisible = refreshState.status != Status.RUNNING
        })

        viewModel.pokemon.observe(viewLifecycleOwner, Observer { pokemon ->
            activity?.title = pokemon?.name
            weight.text = getString(R.string.pokemon_weight, pokemon?.detail?.weight.toString())
            height.text = getString(R.string.pokemon_height, pokemon?.detail?.height.toString())
            type.text= getString(R.string.pokemon_type, pokemon?.detail?.types.toString())







           var typesPoke: String? = pokemon?.detail?.types?.get(0)



            //val constrainL :ConstraintLayout = view.findViewById((R.id.cat_card_list_item_card),
                val constrainL=cat_card_list_item_card
//recup les couleur : .setbackgroundColor(requireContext().getColor(R.color.blue)
//setBackgroundColor(requireContext().getAttributeFromAttr(R.attr.colorPrimary

            when(typesPoke){
                "fire" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.fire))
                "water" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.water))
                "electric" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.electric))
                "grass" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.grass))
                "ice" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.ice))
                "fighting" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.fighting))
                "poison" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.poison))
                "ground" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.ground))
                "flying" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.flying))
                "psychic" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.psychic))
                "bug" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.bug))
                "rock" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.rock))
                "ghost" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.ghost))
                "dragon" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.dragon))
                "dark" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.dark))
                "steel" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.steel))
                "fairy" -> constrainL.setBackgroundColor(requireContext().getColor(R.color.fairy))



            }


//Tentative d'ajout des moove a la list View poke_atk
         // moves.set() = getString(R.string.poke_atk, pokemon?.detail?.moves.toString())
            moves.text= getString(R.string.poke_atk, pokemon?.detail?.moves.toString())


//boucle de récupération des moove + adapteur (pas reussi)
            //Picasso.get().load(pokemon?.iconUrl).into(icon)
            //val listItems = ArrayList<Move>()
            //var pokemonMove: List<Move>? = pokemon?.detail?.moves
            //for(i in pokemonMove!!.iterator()) {
            //    listItems.add(i)
            //}

        })

        viewModel.moves.observe(this, Observer{moves ->
            Log.d("PokemonDetailActivity", "moves :$moves")

        })

    }
}