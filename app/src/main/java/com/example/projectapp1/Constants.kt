package com.example.projectapp1

object Constants{

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What is the capital of Chile?",
            R.drawable.ic_chile,
            "Baku",
            "Abuja",
            "Beirut",
            "Canberra",
            1
        )

        questionsList.add(q1)

        //2
        val q2 = Question(
            2,
            "What is the capital of Iceland?",
            R.drawable.ic_iceland,
            "Helsinki",
            "Dublin",
            "Reykjavik",
            "Havana",
            3
        )

        questionsList.add(q2)

        //3
        val q3 = Question(
            3,
            "What nut is in the middle of a Ferrero Rocher?",
            R.drawable.ic_ferrero,
            "Walnut",
            "Almonds",
            "Cashew",
            "Hazelnut",
            4
        )

        questionsList.add(q3)

        //4
        val q4 = Question(
            4,
            "How many valves does the heart have?",
            R.drawable.ic_heart,
            "One",
            "Two",
            "Three",
            "Four",
            4
        )

        questionsList.add(q4)

        //5
        val q5 = Question(
            5,
            "What does He stand for on the periodic table?",
            R.drawable.ic_helium,
            "Helium",
            "Silver",
            "Quicksilver",
            "Iron",
            1
        )

        questionsList.add(q5)

        //6
        val q6 = Question(
            3,
            "What's a baby rabbit called?",
            R.drawable.ic_kit,
            "Coochie",
            "Piglet",
            "Puppy",
            "Kit",
            4
        )

        questionsList.add(q6)

        //7
        val q7 = Question(
            7,
            "Which nuts are in marzipan?",
            R.drawable.ic_marzipan,
            "Walnuts",
            "Almonds",
            "Pistachio",
            "Macadamia nuts",
            2
        )

        questionsList.add(q7)

        //8
        val q8 = Question(
            8,
            "What is Japanese sake made of?",
            R.drawable.ic_sake,
            "Potato",
            "Wholegrain",
            "Rice",
            "Onion",
            3
        )

        questionsList.add(q8)

        //9
        val q9 = Question(
            9,
            "What was Britney Spears' first single called?",
            R.drawable.ic_venyl_correct,
            "One More Time",
            "Thank You",
            "Betrayal",
            "Lose Yourself",
            1
        )

        questionsList.add(q9)

        //10
        val q10 = Question(
            10,
            "What is the national flower of Japan?",
            R.drawable.ic_flower,
            "Rose",
            "Hortensia",
            "Lotus Flower",
            "Cherry Blossom",
            4
        )

        questionsList.add(q10)


        return questionsList
    }

}