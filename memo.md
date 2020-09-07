# b

val builder = android.app.AlertDialog.Builder(this)
                val inflater = layoutInflater
                val signinView = inflater.inflate(R.layout.dialog_signin, null)

                builder.setView(signinView)
                    .setTitle("Sign in")
                    .setPositiveButton("OK") { _, _ ->
                        val b = signinView.findViewById<EditText>(R.id.email).text.toString()
                        create5(b)
                        println(b)
                    }
                    .setNegativeButton("Cancel") { _, _ ->

                    }

                    .show()
