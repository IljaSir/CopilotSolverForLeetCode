impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max_gold = 0;
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] > 0 {
                    max_gold = max_gold.max(Solution::dfs(&grid, &mut visited, i, j));
                }
            }
        }
        max_gold
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize) -> i32 {
        if i >= grid.len() || j >= grid[0].len() || grid[i][j] == 0 || visited[i][j] {
            return 0;
        }
        visited[i][j] = true;
        let mut max_gold = 0;
        max_gold = max_gold.max(Solution::dfs(grid, visited, i+1, j));
        max_gold = max_gold.max(Solution::dfs(grid, visited, i, j+1));
        max_gold = max_gold.max(Solution::dfs(grid, visited, i, j.checked_sub(1).unwrap_or(0)));
        max_gold = max_gold.max(Solution::dfs(grid, visited, i.checked_sub(1).unwrap_or(0), j));
        visited[i][j] = false;
        max_gold + grid[i][j]
    }
}