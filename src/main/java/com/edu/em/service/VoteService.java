package com.edu.em.service;

import com.edu.em.dto.Stats;
import com.edu.em.dto.Vote;
import com.edu.em.service.api.IVoteService;
import com.edu.em.storage.VoteStorageRam;
import com.edu.em.storage.api.IVoteStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteService implements IVoteService {

    private static final IVoteStorage storage = new VoteStorageRam();

    @Override
    public void add(Vote vote) {
        this.storage.add(vote);
    }

    @Override
    public Stats getStats() {
        Map<String, Integer> artistStats = new HashMap<>();
        Map<String, Integer> genreStats = new HashMap<>();
        List<String> abouts = new ArrayList<>();

        List<Vote> all = storage.getAll();

        for (Vote vote : all) {
            artistStats.compute(vote.getArtist(), (k, v) ->
                    v == null ? 1 : v + 1);


            for (String genre : vote.getGenres()) {
                genreStats.compute(genre, (k, v) ->
                        v == null ? 1 : v + 1);
            }

            abouts.add(vote.getDtCreate() + ": " + vote.getAbout());
        }

        return new Stats(artistStats, genreStats, abouts);
    }
}
