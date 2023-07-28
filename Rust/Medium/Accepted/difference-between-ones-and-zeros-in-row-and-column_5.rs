impl Solution {
    pub fn ones_minus_zeros(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut diff = vec![vec![0; grid[0].len()]; grid.len()];
        let mut ones_row = vec![0; grid.len()];
        let mut ones_col = vec![0; grid[0].len()];
        let mut zeros_row = vec![0; grid.len()];
        let mut zeros_col = vec![0; grid[0].len()];
        for (i, row) in grid.iter().enumerate() {
            for (j, &v) in row.iter().enumerate() {
                if v == 1 {
                    ones_row[i] += 1;
                    ones_col[j] += 1;
                } else {
                    zeros_row[i] += 1;
                    zeros_col[j] += 1;
                }
            }
        }
        for (i, row) in diff.iter_mut().enumerate() {
            for (j, v) in row.iter_mut().enumerate() {
                *v = ones_row[i] + ones_col[j] - zeros_row[i] - zeros_col[j];
            }
        }
        diff
    }
}