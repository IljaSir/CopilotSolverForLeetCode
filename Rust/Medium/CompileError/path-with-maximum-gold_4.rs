impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] > 0 {
                    max = max.max(Solution::dfs(&grid, i, j, 0));
                }
            }
        }
        max
    }
    
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize, sum: i32) -> i32 {
        if i >= grid.len() || j >= grid[0].len() || i < 0 || j < 0 || grid[i][j] == 0 {
            return sum;
        }
        let tmp = grid[i][j];
        grid[i][j] = 0;
        let mut max = 0;
        max = max.max(Solution::dfs(grid, i + 1, j, sum + tmp));
        max = max.max(Solution::dfs(grid, i, j + 1, sum + tmp));
        max = max.max(Solution::dfs(grid, i - 1, j, sum + tmp));
        max = max.max(Solution::dfs(grid, i, j - 1, sum + tmp));
        grid[i][j] = tmp;
        max
    }
}