package com.learn.springboot.service;

import com.learn.springboot.pojo.Post;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.List;


@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "post")
public interface PostRepository extends CouchbasePagingAndSortingRepository<Post, Integer> {
    @Override
    <S extends Post> Iterable<S> saveAll(Iterable<S> iterable);

    List<Post> findTop10ByOrderByTimeDesc();
}
