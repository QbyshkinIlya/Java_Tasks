package model.handlers;

import model.Player;
import model.SlotMachine;

public class WinHandler extends Handler {


        public WinHandler(Handler nextHandler) {
            super(nextHandler);
        }

        @Override
        public void handle(int result, Player player, SlotMachine slotMachine) {
            if (result >= 7) {
                player.addCoins(10);
                slotMachine.removeCoins(10);
                if (player.getCoins() >= 10) {
                    System.out.println("Выберите фишку!");
                } else {
                    getNextHandler().handle(result, player, slotMachine);
                }
            } else {
                getNextHandler().handle(result, player, slotMachine);
            }
        }
    }