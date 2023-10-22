package model.handlers;

import model.Player;
import model.SlotMachine;


public abstract class Handler {
    private Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(int result, Player player, SlotMachine slotMachine);

    public Handler getNextHandler() {
        return nextHandler;
    }
}