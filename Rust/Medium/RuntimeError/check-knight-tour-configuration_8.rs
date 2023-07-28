impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let mut n = grid.len();
        let mut row = 0;
        let mut col = 0;
        let mut visited = vec![vec![false; n]; n];
        for i in 0..n*n {
            if grid[row][col] != i as i32 {
                return false;
            }
            visited[row][col] = true;
            if i == n*n-1 {
                break;
            }
            let mut found = false;
            if row-2 >= 0 && col-1 >= 0 && !visited[row-2][col-1] {
                row -= 2;
                col -= 1;
                found = true;
            } else if row-2 >= 0 && col+1 < n && !visited[row-2][col+1] {
                row -= 2;
                col += 1;
                found = true;
            } else if row-1 >= 0 && col-2 >= 0 && !visited[row-1][col-2] {
                row -= 1;
                col -= 2;
                found = true;
            } else if row-1 >= 0 && col+2 < n && !visited[row-1][col+2] {
                row -= 1;
                col += 2;
                found = true;
            } else if row+1 < n && col-2 >= 0 && !visited[row+1][col-2] {
                row += 1;
                col -= 2;
                found = true;
            } else if row+1 < n && col+2 < n && !visited[row+1][col+2] {
                row += 1;
                col += 2;
                found = true;
            } else if row+2 < n && col-1 >= 0 && !visited[row+2][col-1] {
                row += 2;
                col -= 1;
                found = true;
            } else if row+2 < n && col+1 < n && !visited[row+2][col+1] {
                row += 2;
                col += 1;
                found = true;
            }
            if !found {
                return false;
            }
        }
        true
    }
}