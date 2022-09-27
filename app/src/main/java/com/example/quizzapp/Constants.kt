package com.example.quizzapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"

    fun getQuestions():ArrayList<Question> {

        val questionList = ArrayList<Question>()


            //1
        val que1 = Question(
            1, "What the name of the country of this flag?",R.drawable.ic_flag_of_argentina,
            "India","New Zeland" , "Argentina", "Usa", 3
        )

        questionList.add(que1)

        //1


        //2
        val que2 = Question(
            2, "What the name of the country of this flag?",R.drawable.ic_flag_of_belgium,
            "Belgium","Argentina" , "Kuwait", "Austria", 1
        )

        questionList.add(que2)

        //2

        //3
        val que3 = Question(
            3, "What the name of the country of this flag?",R.drawable.ic_flag_of_brazil,
            "Afghanistan","Algeria" , "Burundi", "Brazil", 4
        )

        questionList.add(que3)

        //3


        //4
        val que4= Question(
            4, "What the name of the country of this flag?",R.drawable.ic_flag_of_denmark,
            "Cambodia","Denmark" , "Costa Rica", "Cuba", 2
        )

        questionList.add(que4)


        //4


        //5
        val que5 = Question(
            5, "What the name of the country of this flag?",R.drawable.ic_flag_of_australia,
            "Australia","Guinea" , "Burundi", "Hungary", 1
        )

        questionList.add(que5)

        //5



        //6
        val que6 = Question(
            6, "What the name of the country of this flag?",R.drawable.ic_flag_of_fiji,
            "Lithuania","Malawi" , "Fiji", "Brazil", 3
        )
        questionList.add(que6)

        //6



        //7
        val que7 = Question(
            7, "What the name of the country of this flag?",R.drawable.ic_flag_of_india,
            "India","Netherlands" , "Morocco", "Maldives", 1
        )

        questionList.add(que7)

        //7


        //8
        val que8 = Question(
            8, "What the name of the country of this flag?",R.drawable.ic_flag_of_germany,
            "India","Denmark" , "Germany", "Maldives", 3
        )

        questionList.add(que8)

        //8



        //9
        val que9 = Question(
            9, "What the name of the country of this flag?",R.drawable.ic_flag_of_kuwait,
            "Germany","Lithuania" , "Morocco", "Kuwait", 4
        )

        questionList.add(que9)

        //9


        return questionList
    }
}