class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] board = new int[8][8];
        for(int[] queen: queens){
            board[queen[0]][queen[1]] = 1;
        }
        int x = king[0];
        int y = king[1];
        // up
        while(x>=0){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            x--;
        }
        x = king[0];
        y = king[1];
        // down
        while(x<8){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            x++;
        }
        x = king[0];
        y = king[1];
        // left
        while(y>=0){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            y--;
        }
        x = king[0];
        y = king[1];
        // right
        while(y<8){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            y++;
        }
        x = king[0];
        y = king[1];
        // left up
        while(x>=0 && y>=0){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            x--;
            y--;
        }
        x = king[0];
        y = king[1];
        // right up
        while(x>=0 && y<8){
            if(board[x][y]==1){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                break;
            }
            x--;
            y++;
        }
        x = king[0];
        y = king[1];
        // left down
        while(x<8 && y>=0){
            if(board
    }
}