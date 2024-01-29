package com.andrelourdes.desafioanotaai.domain.repositories;

import com.andrelourdes.desafioanotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository <Category, String> {
}