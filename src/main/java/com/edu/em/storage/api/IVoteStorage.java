package com.edu.em.storage.api;

import com.edu.em.dto.Vote;

import java.util.List;


public interface IVoteStorage {
    void add(Vote vote);
    List<Vote> getAll();
}

