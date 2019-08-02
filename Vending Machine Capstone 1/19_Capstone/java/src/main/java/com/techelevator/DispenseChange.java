package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class DispenseChange {

    public String dispenseChange (double currentMoney) {
        Coin[] monies = new Coin[] { new Quarter(), new Dime(), new Nickel() };
        currentMoney = 0;

        String result = "";

        Map<Coin, Double> moniesMap = new HashMap<Coin, Double>();

        for (Coin m : monies) {

            if (currentMoney <= 0) { break; }
            double leastChangeNeeded = (currentMoney / m.getValue());

            if (leastChangeNeeded > 0) {
                currentMoney = currentMoney % (m.getValue() * leastChangeNeeded);
                moniesMap.put(m,leastChangeNeeded);
            }
        }

        for (Coin coin : moniesMap.keySet()) {
            result += (moniesMap.get(coin) + " " + coin.getName() + "(s)" + " ");

        }

        return result;
    }

}
