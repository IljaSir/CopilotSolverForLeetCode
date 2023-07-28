impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    count += 1;
                    if count > 1 {
                        return true;
                    }
                    Solution::dfs(i, j, &mut grid);
                }
            }
        }
        false
    }
    fn dfs(i: usize, j: usize, grid: &mut Vec<Vec<i32>>) {
        let m = grid.len();
        let n = grid[0].len();
        if i >= m || j >= n || grid[i][j] == 0 {
            return;
        }
        grid[i][j] = 0;
        Solution::dfs(i + 1, j, grid);
        Solution::dfs(i, j + 1, grid);
    }
}