package com.engineeringgec.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NonNull

public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String UserName;
    @NonNull
    private String Password;

    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();

}
