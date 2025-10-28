package org.example.sokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sokoban {
    static int[] dirRow = { -1, 1, 0, 0 }; // Up, Down, Left, Right
    static int[] dirCol = { 0, 0, -1, 1 };
    static char[][] map;
    static int playerRow, playerCol;
    static Queue<Character> commands;
    static int gameCount = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0)
                break;
            map = new char[r][c];
            playerRow = 0;
            playerCol = 0;
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'w') { //공사필요
                        playerRow = i;
                        playerCol = j;
                    }
                }
            }
            String commandStr = br.readLine();
            commands = new ArrayDeque<>();
            for (int i = 0; i < commandStr.length(); i++) {
                commands.add(commandStr.charAt(i));
            }
            gameCount++;
            simstart();
            if (checkWin()) {
                System.out.println("Game " + (gameCount) + ": complete");
            } else {
                System.out.println("Game " + (gameCount) + ": incomplete");
            }
            for (int i = 0; i < map.length; i++) {
                System.out.println(new String(map[i]));
            }
        }

    }


    private static void simstart() {
        while (commands.size() > 0) {
            char dir = commands.poll();
            move(dir);
        }
    }

    private static boolean isValidMove(int newRow, int newCol) {
        int r = map.length;
        int c = map[0].length;
        return newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && map[newRow][newCol] != '#';
    }

    private static boolean isBoxMoveValid(int boxRow, int boxCol, int newBoxRow, int newBoxCol) {
        int r = map.length;
        int c = map[0].length;
        return newBoxRow >= 0 && newBoxRow < r && newBoxCol >= 0 && newBoxCol < c && map[newBoxRow][newBoxCol] != '#'
                && map[newBoxRow][newBoxCol] != 'b' && map[newBoxRow][newBoxCol] != 'B';
    }

    private static void move(char dir) {
        int dirIndex;
        if (dir == 'U')
            dirIndex = 0;
        else if (dir == 'D')
            dirIndex = 1;
        else if (dir == 'L')
            dirIndex = 2;
        else if (dir == 'R')
            dirIndex = 3;
        else
            return;
        int newRow = playerRow + dirRow[dirIndex];
        int newCol = playerCol + dirCol[dirIndex];
        if (isValidMove(newRow, newCol)) {
            if (map[newRow][newCol] == 'b' || map[newRow][newCol] == 'B') {
                int newBoxRow = newRow + dirRow[dirIndex];
                int newBoxCol = newCol + dirCol[dirIndex];
                if (isBoxMoveValid(newRow, newCol, newBoxRow, newBoxCol)) {
                    if (map[newBoxRow][newBoxCol] == '+'){
                        map[newBoxRow][newBoxCol] = 'B';
                    } else {
                        map[newBoxRow][newBoxCol] = 'b';
                    }
                    if(map[newRow][newCol] == 'B' || map[newRow][newCol] == '+'){
                        if(map[playerRow][playerCol] == 'W'){
                            map[playerRow][playerCol] = '+';
                        } else {
                            map[playerRow][playerCol] = '.';
                        }
                        map[newRow][newCol] = 'W';
                    } else {
                        if(map[playerRow][playerCol] == 'W'){
                            map[playerRow][playerCol] = '+';
                        } else {
                            map[playerRow][playerCol] = '.';
                        }
                        map[newRow][newCol] = 'w';
                    }
                    
                    //map[playerRow][playerCol] = '.';
                    playerRow = newRow;
                    playerCol = newCol;
                } 
            } else if (map[newRow][newCol] == '+') {
                map[newRow][newCol] = 'W';
                map[playerRow][playerCol] = '.';
                playerRow = newRow;
                playerCol = newCol;

            } else {
                map[newRow][newCol] = 'w';
                map[playerRow][playerCol] = '.';
                playerRow = newRow;
                playerCol = newCol;
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(new String(map[i]));
        }
    }

    private static boolean checkWin() {
        int bcount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'b') {
                    bcount++;
                }
            }
        }
        if (bcount > 0)
            return false;
        return true;
    }
}