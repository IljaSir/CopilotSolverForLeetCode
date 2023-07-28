impl Solution {
    pub fn num_magic_squares_inside(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let row = grid.len();
        let col = grid[0].len();
        for i in 0..(row - 2) {
            for j in 0..(col - 2) {
                if grid[i + 1][j + 1] != 5 {
                    continue;
                }
                let mut set = std::collections::HashSet::new();
                let mut sum = 0;
                for k in 0..3 {
                    sum += grid[i][j + k];
                    sum += grid[i + 2][j + k];
                    sum += grid[i + k][j];
                    sum += grid[i + k][j + 2];
                    set.insert(grid[i][j + k]);
                    set.insert(grid[i + 2][j + k]);
                    set.insert(grid[i + k][j]);
                    set.insert(grid[i + k][j + 2]);
                }
                if sum == 15 * 8 && set.len() == 9 {
                    res += 1;
                }
            }
        }
        res
    }
}