class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int[][][] visited = new int[grid.length][grid[0].length()][3];
        int[] catPos = new int[2];
        int[] mousePos = new int[2];
        int[] foodPos = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length(); j++){
                if(grid[i].charAt(j) == 'C'){
                    catPos[0] = i;
                    catPos[1] = j;
                }else if(grid[i].charAt(j) == 'M'){
                    mousePos[0] = i;
                    mousePos[1] = j;
                }else if(grid[i].charAt(j) == 'F'){
                    foodPos[0] = i;
                    foodPos[1] = j;
                }
            }
        }
        return helper(grid, catPos, mousePos, foodPos, catJump, mouseJump, visited);
    }
    
    private boolean helper(String[] grid, int[] catPos, int[] mousePos, int[] foodPos, int catJump, int mouseJump, int[][][] visited){
        if(mousePos[0] == foodPos[0] && mousePos[1] == foodPos[1]){
            return true;
        }
        if(catPos[0] == foodPos[0] && catPos[1] == foodPos[1]){
            return false;
        }
        if(visited[mousePos[0]][mousePos[1]][0] == 1){
            return visited[mousePos[0]][mousePos[1]][1] == 1;
        }
        visited[mousePos[0]][mousePos[1]][0] = 1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs){
            int x = mousePos[0];
            int y = mousePos[1];
            int count = 0;
            while(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length() && count < mouseJump && grid[x].charAt(y) != '#'){
                x += dir[0];
                y += dir[1];
                count++;
            }
            if(count >
    }
}