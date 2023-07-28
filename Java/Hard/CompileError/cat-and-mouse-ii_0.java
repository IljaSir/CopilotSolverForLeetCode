class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int m = grid.length, n = grid[0].length();
        int[] mouse = new int[2], cat = new int[2], food = new int[2];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                } else if (grid[i].charAt(j) == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                } else if (grid[i].charAt(j) == 'F') {
                    food[0] = i;
                    food[1] = j;
                }
            }
        }
        return dfs(grid, cat, mouse, food, catJump, mouseJump, new HashMap<>());
    }
    private boolean dfs(String[] grid, int[] cat, int[] mouse, int[] food, int catJump, int mouseJump, Map<String, Boolean> memo) {
        int m = grid.length, n = grid[0].length();
        String key = cat[0] + " " + cat[1] + " " + mouse[0] + " " + mouse[1];
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = 0; i < 4; ++i) {
            int[] newCat = new int[]{cat[0] + dirs[i][0], cat[1] + dirs[i][1]};
            if (newCat[0] >= 0 && newCat[0] < m && newCat[1] >= 0 && newCat[1] < n && grid[newCat[0]].charAt(newCat[1]) != '#') {
                if (newCat[0] == mouse[0] && newCat[1] == mouse[1]) {
                    continue;
                }
                if (newCat[0] == food[0] && newCat[1] == food[1]) {
                    memo.put(key, false);
                    return false;
                }
                for (int j = 0; j < 4; ++j) {
                    int[] newMouse = new int[]{mouse[0] + dirs[j][0
    }
}