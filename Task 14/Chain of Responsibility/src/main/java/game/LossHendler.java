package game;

import model.Player;
import model.SlotMachine;

public class LossHendler extends Handler{
    public LossHendler() {

        super(null);
    }

    @Override
    public void handle(int result, Player player, SlotMachine slotMachine) {
        if (player.getCoins() <= 0) {
            System.out.println("Вы проиграли все монеты!");
        } else if (slotMachine.getCoins() <= 0) {
            System.out.println("Автомат проиграл");
        }
    }
}
