impl Solution {
    pub fn ones_minus_zeros(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![vec![0; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                let mut ones_row = 0;
                let mut ones_col = 0;
                let mut zeros_row = 0;
                let mut zeros_col = 0;
                for k in 0..grid.len() {
                    if grid[k][j] == 1 {
                        ones_row += 1;
                    } else {
                        zeros_row += 1;
                    }
                }
                for k in 0..grid[0].len() {
                    if grid[i][k] == 1 {
                        ones_col += 1;
                    } else {
                        zeros_col += 1;
                    }
                }
                result[i][j] = ones_row + ones_col - zeros_row - zeros_col;
            }
        }
        result
    }
}