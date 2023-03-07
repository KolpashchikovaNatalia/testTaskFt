package org.example;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int N = 0; // cards count
    static int C = 0; // players count
    static char[] colors = {'R', 'G', 'B', 'W'};
    static HashMap<String, String> players = new <String, String>HashMap<String, String>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            String cmd = in.next();
            if (cmd.equals("start")) {
                players.clear();
                N = in.nextInt();
                C = in.nextInt();
                if (N * C > 40) {
                    System.out.printf("Не могу раздать %d карт(ы) %d игрокам: в колоде только 40 карт%n",
                            N * C, C);
                    System.out.println("Введите корректные значения");
                    continue;
                }
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < C; c++) {
                    for (int n = 0; n < N; n++) {
                        String str = String.format("%c%d", colors[random.nextInt(colors.length)],
                                random.nextInt(10) + 1);
                        sb.append(str).append(" ");
                    }
                    players.put(String.format("Player #%d", c + 1), sb.toString());
                    sb.setLength(0);
                }

            } else if (cmd.equals("get-cards")) {
                C = in.nextInt();
                String player = String.format("Player #%d", C);
                String cards = players.get(player);
                System.out.printf("%d %s\n", C, cards);
            } else if (cmd.equals("exit")){
                break;
            }
        }
    }
}