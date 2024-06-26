impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut max_area = 0;
        let mut grid = grid;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    let area = Self::dfs(&mut grid, i, j);
                    if area > max_area {
                        max_area = area;
                    }
                }
            }
        }
        max_area
    }
    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        if i < 0 || i >= grid.len() || j < 0 || j >= grid[i].len() || grid[i][j] != 1 {
            return 0;
        }
        grid[i][j] = 2;
        1 + Self::dfs(grid, i - 1, j) + Self::dfs(grid, i + 1, j) + Self::dfs(grid, i, j - 1) + Self::dfs(grid, i, j + 1)
    }
}