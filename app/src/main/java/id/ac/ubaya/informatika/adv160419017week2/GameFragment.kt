package id.ac.ubaya.informatika.adv160419017week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val randomNumber1 = (0..50).random()
        val randomNumber2 = (0..50).random()
        val answer = randomNumber1 + randomNumber2

        textViewNumber1.text = randomNumber1.toString()
        textViewNumber2.text = randomNumber2.toString()
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            textViewName.text = "$playerName's Turn"
        }
        buttonSumbitAnswer.setOnClickListener{
            val answerInput = editAnswer.text.toString().toInt()
            var score = 0

            if(answerInput == answer)
                score = 1
            else
                score = 0

            val action = GameFragmentDirections.actionToGameOver(score)
            Navigation.findNavController(it).navigate(action)
        }
    }
}