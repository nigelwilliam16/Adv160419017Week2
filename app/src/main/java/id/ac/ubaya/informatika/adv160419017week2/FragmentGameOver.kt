package id.ac.ubaya.informatika.adv160419017week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game_over.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentGameOver.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentGameOver : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var playerScore = FragmentGameOverArgs.fromBundle(requireArguments()).playerScore
            textViewScore.text = "Your score is $playerScore"
        }
        buttonSumbitAnswer.setOnClickListener{
            val action = GameFragmentDirections.actionToGameOver(editAnswer.text.toString().toInt())
            Navigation.findNavController(it).navigate(action)
        }
    }
}