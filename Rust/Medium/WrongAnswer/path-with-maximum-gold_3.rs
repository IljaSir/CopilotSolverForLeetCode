impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] > 0 {
                    max = max.max(Solution::dfs(&grid, i, j));
                }
            }
        }
        max
    }
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        let mut max = 0;
        let mut grid = grid.clone();
        grid[i][j] = 0;
        if i > 0 && grid[i-1][j] > 0 {
            max = max.max(Solution::dfs(&grid, i-1, j));
        }
        if i < grid.len()-1 && grid[i+1][j] > 0 {
            max = max.max(Solution::dfs(&grid, i+1, j));
        }
        if j > 0 && grid[i][j-1] > 0 {
            max = max.max(Solution::dfs(&grid, i, j-1));
        }
        if j < grid[0].len()-1 && grid[i][j+1] > 0 {
            max = max.max(Solution::dfs(&grid, i, j+1));
        }
        max + grid[i][j] + 1
    }
}