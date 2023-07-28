impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut i = 0;
        let mut j = 0;
        while i < n {
            if grid[i][j] == 0 {
                return false;
            }
            i += 1;
            j += 1;
        }
        i = 0;
        j = n - 1;
        while i < n {
            if grid[i][j] == 0 {
                return false;
            }
            i += 1;
            j -= 1;
        }
        for i in 0..n {
            for j in 0..n {
                if i == j || i + j == n - 1 {
                    continue;
                }
                if grid[i][j] != 0 {
                    return false;
                }
            }
        }
        true
    }
}