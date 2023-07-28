impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max_gold = 0;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                let mut gold = 0;
                Solution::dfs(&grid, i, j, &mut visited, &mut gold);
                max_gold = max_gold.max(gold);
            }
        }
        max_gold
    }
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>, gold: &mut i32) {
        if i >= grid.len() || j >= grid[0].len() || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0 {
            return;
        }
        visited[i][j] = true;
        *gold += grid[i][j];
        Solution::dfs(grid, i+1, j, visited, gold);
        Solution::dfs(grid, i-1, j, visited, gold);
        Solution::dfs(grid, i, j+1, visited, gold);
        Solution::dfs(grid, i, j-1, visited, gold);
        visited[i][j] = false;
    }
}