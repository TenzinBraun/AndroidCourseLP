package fr.iutmindfuck.qr_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.iutmindfuck.qr_code.bean.Card
import fr.iutmindfuck.qr_code.bean.ListCard

class MainActivity : AppCompatActivity() {

     private var listCard:ListCard? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cards:ArrayList<Card> = ArrayList()
        cards.add(Card("#A85F6A", "ALLOOOO"))
        cards.add(Card("#2E6FAD", "SALUT"))
        cards.add(Card("#865EA8", "BONJOUR"))
        cards.add(Card("#D86CB8", "TEST"))
        listCard = ListCard(cards)
    }
}
