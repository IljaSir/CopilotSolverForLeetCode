impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut max_area = 0;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 && !visited[i][j] {
                    let mut area = 0;
                    Self::dfs(&grid, &mut visited, i, j, &mut area);
                    max_area = max_area.max(area);
                }
            }
        }
        max_area
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize, area: &mut i32) {
        if i >= grid.len() || j >= grid[0].len() || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0 {
            return;
        }
        visited[i][j] = true;
        *area += 1;
        Self::dfs(grid, visited, i + 1, j, area);
        Self::dfs(grid, visited, i - 1, j, area);
        Self::dfs(grid, visited, i, j + 1, area);
        Self::dfs(grid, visited, i, j - 1, area);
    }
}