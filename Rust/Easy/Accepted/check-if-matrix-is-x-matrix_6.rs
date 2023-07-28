impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let mut is_x = true;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if i == j || i + j == grid.len() - 1 {
                    if grid[i][j] == 0 {
                        is_x = false;
                        break;
                    }
                } else {
                    if grid[i][j] != 0 {
                        is_x = false;
                        break;
                    }
                }
            }
        }
        is_x
    }
}