impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut grid = grid;
        let mut max_area = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    let area = Self::dfs(&mut grid, i, j);
                    max_area = std::cmp::max(max_area, area);
                }
            }
        }
        max_area
    }

    fn dfs(grid: &mut Vec<Vec<i32>>, i: usize, j: usize) -> i32 {
        if i >= grid.len() || j >= grid[i].len() || grid[i][j] == 0 {
            return 0;
        }
        grid[i][j] = 0;
        let mut area = 1;
        area += Self::dfs(grid, i, j + 1);
        area += Self::dfs(grid, i + 1, j);
        area += Self::dfs(grid, i, if j > 0 { j - 1 } else { 0 });
        area += Self::dfs(grid, if i > 0 { i - 1 } else { 0 }, j);
        area
    }
}