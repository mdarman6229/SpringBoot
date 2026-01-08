package com.engineeringgec.Repository;

import com.engineeringgec.Entity.JournalEntry;
import com.engineeringgec.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String UserName);
}
