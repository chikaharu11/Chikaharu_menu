mRealm.executeTransaction {
                    mRealm.where<Book>().equalTo("name",item).findAll().deleteAllFromRealm()
                }
