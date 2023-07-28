impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut row = 0;
        let mut col = 0;
        while row < n && col < n {
            if grid[row][col] == 0 {
                return false;
            }
            row += 1;
            col += 1;
        }
        row = 0;
        col = n - 1;
        while row < n && col >= 0 {
            if grid[row][col] == 0 {
                return false;
            }
            row += 1;
            col -= 1;
        }
        for i in 0..n {
            for j in 0..n {
                if i != j && i + j != n - 1 && grid[i][j] != 0 {
                    return false;
                }
            }
        }
        true
    }
}