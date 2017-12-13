package com.r2m.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URISyntaxException;
import java.time.Instant;
import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.r2m.model.Bet;
import com.r2m.model.User;
import com.r2m.repository.BetRepository;
import com.r2m.repository.UserRepository;
import com.r2m.service.SlotMachineService;

@Controller
@RequestMapping(path = "/game")
public class GameController {
	
	
	@Autowired
	BetRepository betRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SlotMachineService slotMachineService;

	/**
	 * Get
	 * @param userId
	 * @return
	 * @throws URISyntaxException
	 */
    @RequestMapping(value="/slotmachinebet", method = GET)
    public ResponseEntity<Bet> getBetSlotMachineE(@RequestParam(value="userId") Long userId) throws URISyntaxException {
        User user = userRepository.findOne(userId);
        Bet bet = new Bet();
        if(user == null) {
			return new ResponseEntity<Bet>(bet, HttpStatus.NOT_FOUND);
		}
        
        bet.setId(UUID.randomUUID());
        bet.setUserId(null);
        bet.setBetDate(Instant.now());
        bet.setBetQuantity(0D);
        bet.setPrizeAmount(100D);
        bet.setResultCombo(slotMachineService.bet(null));
        bet.setWin(false);
        
        int count = 0;
        
        for (int i = 0; i < SlotMachineService.slots - 1; i++) {
        	if(bet.getResultCombo()[i].equals(bet.getResultCombo()[i+1]) ){
        		count++;
        	}
        }
        
        if(count >= SlotMachineService.slots -1){
        	bet.setWin(true);
        } else {
        	bet.setWin(false);
        }
        
        return new ResponseEntity<Bet>(bet, HttpStatus.FOUND);
    }
	
	/**
	 * Create a new shopping bet for a given userId
	 * @param userId
	 * @return
	 * @throws URISyntaxException
	 */
    @RequestMapping(value="/addbet", method = POST)
    public ResponseEntity<Bet> createBet(Bet bet) throws URISyntaxException {
		try {
			betRepository.save(bet);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<Bet>(bet, HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<Bet>(bet, HttpStatus.CREATED);
    }
	
}
