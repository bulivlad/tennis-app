package com.example.tennis.controller;

import com.example.tennis.dto.WinnerDTO;
import com.example.tennis.repository.TournamentRepository;
import com.example.tennis.service.TourMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournaments/matches")
public class TourMatchController {

    @Autowired
    private TourMatchService tourMatchService;

    @Autowired
    private TournamentRepository tournamentRepository;

//    @PostMapping("/add")
//    public void add(@RequestBody TourMatch tourMatch){
//        this.tourMatchService.saveTourMatch(tourMatch);
//    }

    @PostMapping("/updateWinner")
    public void updateWinner(@RequestBody WinnerDTO winnerDTO){
        tourMatchService.updateMatchWinner(winnerDTO.getTourMatchId(), winnerDTO.getPlayerNumber(), winnerDTO.getFirstPlayersScore(), winnerDTO.getSecondPlayersScore());
    }

    @PostMapping("/drawPlayers/{tournamentId}")
    public void drawPlayers(@PathVariable String tournamentId){
        tourMatchService.drawMatches(tournamentRepository.findById(tournamentId).orElse(null));
    }

}
