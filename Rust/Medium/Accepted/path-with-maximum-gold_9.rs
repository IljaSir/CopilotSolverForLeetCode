impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max_gold = 0;
        let mut grid = grid;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] != 0 {
                    let gold = Self::dfs(&mut grid, &mut visited, i, j);
                    max_gold = max_gold.max(gold);
                }
            }
        }
        max_gold
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize) -> i32 {
        if grid[i][j] == 0 || visited[i][j] {
            return 0;
        }
        visited[i][j] = true;
        let mut gold = grid[i][j];
        if i > 0 {
            gold += Self::dfs(grid, visited, i - 1, j);
        }
        if i + 1 < grid.len() {
            gold = gold.max(grid[i][j] + Self::dfs(grid, visited, i + 1, j));
        }
        if j > 0 {
            gold = gold.max(grid[i][j] + Self::dfs(grid, visited, i, j - 1));
        }
        if j + 1 < grid[0].len() {
            gold = gold.max(grid[i][j] + Self::dfs(grid, visited, i, j + 1));
        }
        visited[i][j] = false;
        gold
    }
}