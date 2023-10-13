/*
 * Decompiled with CFR 0.144.
 */
package game.xizach.server;

import game.xizach.server.logic.CardSuit;
import java.util.List;
import java.util.Random;

public class GameLogic {
    public CardSuit cardSuit = new CardSuit();
    public int firstTurn = -1;
    public boolean sam = false;
    public Random rd = new Random();

    public byte[] genFirstTurn() {
        this.cardSuit.setRandomFirstTurn();
        byte[] cards = new byte[6];
        int i = 0;
        int count = 0;
        int CHAT = this.rd.nextInt(4);
        while (i < 6) {
            int cardId = this.cardSuit.ids.get(count++);
            int so = cardId / 4;
            int chat = cardId % 4;
            if (so == 1 || chat != CHAT) continue;
            cards[i++] = (byte)cardId;
        }
        return cards;
    }
}
