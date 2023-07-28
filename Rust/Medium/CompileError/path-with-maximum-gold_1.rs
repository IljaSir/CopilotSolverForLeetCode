impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut max_gold = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] != 0 {
                    max_gold = max_gold.max(Solution::dfs(&grid, i, j));
                }
            }
        }
        max_gold
    }
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        if i >= grid.len() || j >= grid[0].len() || i < 0 || j < 0 {
            return 0;
        }
        if grid[i][j] == 0 {
            return 0;
        }
        let mut max_gold = 0;
        let tmp = grid[i][j];
        grid[i][j] = 0;
        max_gold = max_gold.max(Solution::dfs(grid, i, j + 1));
        max_gold = max_gold.max(Solution::dfs(grid, i, j - 1));
        max_gold = max_gold.max(Solution::dfs(grid, i + 1, j));
        max_gold = max_gold.max(Solution::dfs(grid, i - 1, j));
        grid[i][j] = tmp;
        max_gold + tmp
    }
}