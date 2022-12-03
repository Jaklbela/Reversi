public class Game {
    static int max_points = 0;

    public static void SmallBotGame() {
        Map map = new Map();
        map.DrawSndMap(map.o_player_data, map.x_player_data);
        Human player = new Human();
        NormalBot bot = new NormalBot();
        while (true) {
            boolean fstCheck = player.Move(map.x_player_data, map.o_player_data, map, true);
            if (!fstCheck)
                System.out.println("No possible moves. Other player makes move");
            boolean sndCheck = bot.Move(map.o_player_data, map.x_player_data, map, false);
            if (!sndCheck) {
                if (!fstCheck) {
                    System.out.println("End of the game!");
                    PrintWinner(map);
                    return;
                }
                System.out.println("No possible moves. Other player makes move");
            }
        }
    }

    public static void CoolBotGame() {
        Map map = new Map();
        map.DrawSndMap(map.o_player_data, map.x_player_data);
        Human player = new Human();
        CoolBot bot = new CoolBot();
        while (true) {
            boolean fstCheck = player.Move(map.x_player_data, map.o_player_data, map, true);
            if (!fstCheck)
                System.out.println("No possible moves. Other player makes move");
            boolean sndCheck = bot.Move(map.o_player_data, map.x_player_data, map, false);
            if (!sndCheck) {
                if (!fstCheck) {
                    System.out.println("End of the game!");
                    PrintWinner(map);
                    return;
                }
                System.out.println("No possible moves. Other player makes move");
            }
        }
    }

    public static void PVPGame() {
        Map map = new Map();
        map.DrawSndMap(map.o_player_data, map.x_player_data);
        Human fst_player = new Human();
        Human snd_player = new Human();
        while (true) {
            boolean fstCheck = fst_player.Move(map.x_player_data, map.o_player_data, map, true);
            if (!fstCheck)
                System.out.println("No possible moves. Other player makes move");
            boolean sndCheck = snd_player.Move(map.o_player_data, map.x_player_data, map, false);
            if (!sndCheck) {
                if (!fstCheck) {
                    System.out.println("End of the game!");
                    int[] points = CountPoints(map);
                    if (points[1] > max_points)
                        max_points = points[1];
                    PrintWinner(map);
                    return;
                }
                System.out.println("No possible moves. Other player makes move");
            }
        }
    }

    private static int[] CountPoints(Map map) {
        int[] points = new int[] {0, 0};
        for (boolean[] row : map.x_player_data) {
            for (boolean el : row) {
                if (el)
                    points[0]++;
            }
        }
        if (points[0] > max_points)
            max_points = points[0];
        for (boolean[] row : map.o_player_data) {
            for (boolean el : row) {
                if (el)
                    points[1]++;
            }
        }
        return points;
    }

    private static void PrintWinner(Map map) {
        int[] points = CountPoints(map);
        if (points[0] > points[1]) {
            System.out.println("First player won with " + points[0] + " points");
        } else if (points[0] < points[1]) {
            System.out.println("Second player won with " + points[1] + " points");
        } else {
            System.out.println("Tie!");
        }
    }
}
