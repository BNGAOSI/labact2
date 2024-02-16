package com.example.fulldashboardededdneddy.Repository

import androidx.lifecycle.MutableLiveData
import com.example.fulldashboardededdneddy.model.Documents
import com.example.fulldashboardededdneddy.model.StatusDocuments
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StatusRepository() {
    
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("RequestedDocuments")

    @Volatile
    private var INSTANCE: StatusRepository? = null
    fun getInstance(): StatusRepository {
        return INSTANCE ?: synchronized(this) {
            val instance = StatusRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadDocuments(uid: String, documentType: String, documentList: MutableLiveData<List<StatusDocuments>>) {
        val userDocumentsRef = databaseReference.child(documentType).child(uid)

        userDocumentsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val statusList: List<StatusDocuments> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(StatusDocuments::class.java)!!
                    }
                    documentList.postValue(statusList)
                } catch (e: Exception) {
                    // Handle the exception if needed
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error if needed
            }
        })
    }


}