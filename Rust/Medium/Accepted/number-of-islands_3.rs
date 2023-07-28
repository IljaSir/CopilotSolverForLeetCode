impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        

        let mut grid = grid;
        let mut islands = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == '1' {
                    islands += 1;
                    Solution::dfs(&mut grid, i, j);
                }
            }
        }
        islands
    }
    fn dfs(grid: &mut Vec<Vec<char>>, i: usize, j: usize) {
        if i >= grid.len() || j >= grid[i].len() || grid[i][j] != '1' {
            return;
        }
        grid[i][j] = 'X';
        Solution::dfs(grid, i + 1, j);
        Solution::dfs(grid, i, j + 1);
        Solution::dfs(grid, i - 1, j);
        Solution::dfs(grid, i, j - 1);
    }
}