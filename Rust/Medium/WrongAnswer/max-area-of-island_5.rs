impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut max_area = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    let mut area = 0;
                    Self::dfs(&grid, &mut visited, m, n, i, j, &mut area);
                    max_area = max_area.max(area);
                }
            }
        }
        max_area
    }
    fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, m: usize, n: usize, i: usize, j: usize, area: &mut i32) {
        if i >= m || j >= n || i == 0 || j == 0 {
            return;
        }
        if visited[i][j] || grid[i][j] == 0 {
            return;
        }
        visited[i][j] = true;
        *area += 1;
        Self::dfs(grid, visited, m, n, i + 1, j, area);
        Self::dfs(grid, visited, m, n, i - 1, j, area);
        Self::dfs(grid, visited, m, n, i, j + 1, area);
        Self::dfs(grid, visited, m, n, i, j - 1, area);
    }
}