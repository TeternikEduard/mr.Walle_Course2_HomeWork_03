package com.edu.em.service.api;

import com.edu.em.dto.Stats;
import com.edu.em.dto.Vote;

public interface IVoteService {
    void add(Vote vote);
    Stats getStats();
}
