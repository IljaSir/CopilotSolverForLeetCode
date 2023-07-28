impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        
        let (mut perimeter, mut islands, mut neighbours) = (0, 0, 0);
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    islands += 1;
                    if i < grid.len() - 1 && grid[i + 1][j] == 1 {
                        neighbours += 1;
                    }
                    if j < grid[i].len() - 1 && grid[i][j + 1] == 1 {
                        neighbours += 1;
                    }
                }
            }
        }
        perimeter = 4 * islands - 2 * neighbours;
        perimeter
    }
}