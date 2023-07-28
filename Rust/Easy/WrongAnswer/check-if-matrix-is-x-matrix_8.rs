impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let mut n = grid.len();
        let mut i = 0;
        let mut j = 0;
        let mut k = n - 1;
        let mut l = n - 1;
        let mut is_x_matrix = true;
        while i < n && j < n && k >= 0 && l >= 0 {
            if grid[i][j] == 0 || grid[k][l] == 0 {
                is_x_matrix = false;
                break;
            }
            if i == 0 || i == n - 1 {
                j += 1;
                l -= 1;
            } else {
                j += 1;
                k -= 1;
            }
            i += 1;
        }
        if is_x_matrix {
            for i in 0..n {
                for j in 0..n {
                    if i == j || i + j == n - 1 {
                        continue;
                    } else {
                        if grid[i][j] != 0 {
                            is_x_matrix = false;
                            break;
                        }
                    }
                }
            }
        }
        is_x_matrix
    }
}