package fr.iutmindfuck.qr_code.bean

class ListCard(val listOfCard:ArrayList<Card>){

    fun addCard(color:String, text:String){
        listOfCard.add(Card(color,text))
    }
}