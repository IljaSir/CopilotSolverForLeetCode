impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut grid = grid;
        let mut max_area = 0;
        let mut cur_area = 0;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 && !visited[i][j] {
                    cur_area = 0;
                    Solution::dfs(&mut grid, i, j, &mut visited, &mut cur_area);
                    max_area = max_area.max(cur_area);
                }
            }
        }
        max_area
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>, cur_area: &mut i32) {
        if i >= grid.len() || j >= grid[0].len() || grid[i][j] == 0 || visited[i][j] {
            return;
        }
        visited[i][j] = true;
        *cur_area += 1;
        Solution::dfs(grid, i+1, j, visited, cur_area);
        Solution::dfs(grid, i, j+1, visited, cur_area);
        Solution::dfs(grid, i.saturating_sub(1), j, visited, cur_area);
        Solution::dfs(grid, i, j.saturating_sub(1), visited, cur_area);
    }
}