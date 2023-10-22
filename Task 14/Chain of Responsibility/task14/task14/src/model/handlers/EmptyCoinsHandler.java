package model.handlers;

import model.Player;
import model.SlotMachine;

public class EmptyCoinsHandler extends Handler {
    public EmptyCoinsHandler() {
        super(null);
    }

    @Override
    public void handle(int result, Player player, SlotMachine slotMachine) {
        if (player.getCoins() <= 0) {
            System.out.println("У вас закончились монеты!");
        } else if (slotMachine.getCoins() <= 0) {
            System.out.println("Монеты в автомате закончились!");
        }
        System.out.println("Игра окончена");
    }
}