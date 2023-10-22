package model.handlers;

import model.Player;
import model.SlotMachine;

public class LoseHandler extends Handler {
    public LoseHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int result, Player player, SlotMachine slotMachine) {
        player.removeCoins(10);
        slotMachine.addCoins(10);

        if (player.getCoins() > 0) {
            getNextHandler().handle(result, player, slotMachine);
        } else {
            getNextHandler().handle(result, player, slotMachine);
        }
    }
}