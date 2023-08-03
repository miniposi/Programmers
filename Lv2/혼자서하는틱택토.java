class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int numO = 0;
        int numX = 0;
        int[][] tile = new int[3][3];
        for (int i = 0; i < 3; i++) {
            tile[i] = new int[3];
            for (int j = 0; j < 3; j++) {
                if (board[i].substring(j, j+1).equals("O")) {
                    numO++;
                    tile[i][j] = 0;
                }
                else if (board[i].substring(j, j+1).equals("X")) {
                    numX++;
                    tile[i][j] = 1;
                }
                else
                    tile[i][j] = -1;
            }
        }
        
        // 1. O와 X의 개수 확인
        if (numX > numO || numO-numX > 1)
            return 0;

        // 2. 게임이 정상적으로 종료되었는지 확인
        if (numX == numO) {
            if (tile[0][0] == 0 && tile[0][1] == 0 && tile[0][2] == 0)
                return 0;
            else if (tile[1][0] == 0 && tile[1][1] == 0 && tile[1][2] == 0)
                return 0;
            else if (tile[2][0] == 0 && tile[2][1] == 0 && tile[2][2] == 0)
                return 0;
            else if (tile[0][0] == 0 && tile[1][0] == 0 && tile[2][0] == 0)
                return 0;
            else if (tile[0][1] == 0 && tile[1][1] == 0 && tile[2][1] == 0)
                return 0;
            else if (tile[0][2] == 0 && tile[1][2] == 0 && tile[2][2] == 0)
                return 0;
            else if (tile[0][0] == 0 && tile[1][1] == 0 && tile[2][2] == 0)
                return 0;
            else if (tile[0][2] == 0 && tile[1][1] == 0 && tile[2][0] == 0)
                return 0;
        }
        
        if (numO == numX+1) {
            if (tile[0][0] == 1 && tile[0][1] == 1 && tile[0][2] == 1)
                return 0;
            else if (tile[1][0] == 1 && tile[1][1] == 1 && tile[1][2] == 1)
                return 0;
            else if (tile[2][0] == 1 && tile[2][1] == 1 && tile[2][2] == 1)
                return 0;
            else if (tile[0][0] == 1 && tile[1][0] == 1 && tile[2][0] == 1)
                return 0;
            else if (tile[0][1] == 1 && tile[1][1] == 1 && tile[2][1] == 1)
                return 0;
            else if (tile[0][2] == 1 && tile[1][2] == 1 && tile[2][2] == 1)
                return 0;
            else if (tile[0][0] == 1 && tile[1][1] == 1 && tile[2][2] == 1)
                return 0;
            else if (tile[0][2] == 1 && tile[1][1] == 1 && tile[2][0] == 1)
                return 0;
        }
        
        return 1;
    }
}
