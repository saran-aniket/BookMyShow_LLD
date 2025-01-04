package com.lldbackend.bms_lld_123124.services;

import com.lldbackend.bms_lld_123124.models.ShowSeat;
import com.lldbackend.bms_lld_123124.models.ShowSeatType;
import com.lldbackend.bms_lld_123124.repositories.ShowSeatRepository;
import com.lldbackend.bms_lld_123124.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeatList){
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowId(showSeatList.get(0).getShow().getId());
        for(ShowSeat showSeat : showSeatList){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getShow().getId().equals(showSeatType.getShow().getId())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

}
