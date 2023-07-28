impl Solution {
    pub fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut north_skyline: Vec<i32> = vec![0; grid.len()];
        let mut west_skyline: Vec<i32> = vec![0; grid[0].len()];
        let mut increase = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] > north_skyline[i] {
                    north_skyline[i] = grid[i][j];
                }
                if grid[i][j] > west_skyline[j] {
                    west_skyline[j] = grid[i][j];
                }
            }
        }
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if north_skyline[i] > west_skyline[j] {
                    increase += west_skyline[j] - grid[i][j];
                } else {
                    increase += north_skyline[i] - grid[i][j];
                }
            }
        }
        increase
    }
}