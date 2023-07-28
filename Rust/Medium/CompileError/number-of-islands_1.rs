impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        

        let mut grid = grid;
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == '1' {
                    count += 1;
                    dfs(&mut grid, i, j);
                }
            }
        }
        count
    }
}