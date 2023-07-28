impl Solution {
    pub fn check_x_matrix(grid: Vec<Vec<i32>>) -> bool {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = grid.len() - 1;
        let mut l = grid.len() - 1;
        while i < grid.len() && j < grid.len() && k >= 0 && l >= 0 {
            if grid[i][j] == 0 || grid[k][l] == 0 {
                return false;
            }
            if grid[i][j] != 0 && grid[k][l] != 0 {
                count += 1;
            }
            i += 1;
            j += 1;
            k -= 1;
            l -= 1;
        }
        if count == grid.len() {
            for i in 0..grid.len() {
                for j in 0..grid.len() {
                    if i != j && i + j != grid.len() - 1 && grid[i][j] != 0 {
                        return false;
                    }
                }
            }
            return true;
        }
        false
    }
}