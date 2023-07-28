impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut max = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] > 0 {
                    let mut visited = vec![vec![false; n]; m];
                    let mut cur_max = 0;
                    Solution::dfs(&grid, &mut visited, i, j, &mut cur_max);
                    max = max.max(cur_max);
                }
            }
        }
        max
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize, cur_max: &mut i32) {
        let m = grid.len();
        let n = grid[0].len();
        if i >= m || j >= n || visited[i][j] {
            return;
        }
        if grid[i][j] == 0 {
            return;
        }
        visited[i][j] = true;
        *cur_max += grid[i][j];
        Solution::dfs(grid, visited, i + 1, j, cur_max);
        Solution::dfs(grid, visited, i, j + 1, cur_max);
        Solution::dfs(grid, visited, i, j.checked_sub(1).unwrap_or(0), cur_max);
        Solution::dfs(grid, visited, i.checked_sub(1).unwrap_or(0), j, cur_max);
        visited[i][j] = false;
        *cur_max -= grid[i][j];
    }
}