impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let mut flag: bool = true;
        let mut i: usize = 0;
        let mut j: usize = 0;
        let mut k: usize = 0;
        let mut m: usize = grid.len() - 1;
        while i < grid.len() {
            j = 0;
            while j < grid.len() {
                if i == j {
                    if grid[i][j] == 0 {
                        flag = false;
                    }
                } else if i + j == m {
                    if grid[i][j] == 0 {
                        flag = false;
                    }
                } else if grid[i][j] != 0 {
                    flag = false;
                }
                j += 1;
            }
            i += 1;
        }
        flag
    }
}