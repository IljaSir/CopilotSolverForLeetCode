impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        let mut x = 0;
        let mut y = 0;
        for i in 0..n*n {
            if grid[x][y] != i as i32 {
                return false;
            }
            visited[x][y] = true;
            let mut next_x = x;
            let mut next_y = y;
            if x + 2 < n && y + 1 < n && !visited[x+2][y+1] {
                next_x = x + 2;
                next_y = y + 1;
            } else if x + 2 < n && y > 0 && !visited[x+2][y-1] {
                next_x = x + 2;
                next_y = y - 1;
            } else if x + 1 < n && y + 2 < n && !visited[x+1][y+2] {
                next_x = x + 1;
                next_y = y + 2;
            } else if x + 1 < n && y > 1 && !visited[x+1][y-2] {
                next_x = x + 1;
                next_y = y - 2;
            } else if x > 1 && y + 2 < n && !visited[x-1][y+2] {
                next_x = x - 1;
                next_y = y + 2;
            } else if x > 1 && y > 1 && !visited[x-1][y-2] {
                next_x = x - 1;
                next_y = y - 2;
            } else if x > 0 && y + 1 < n && !visited[x-2][y+1] {
                next_x = x - 2;
                next_y = y + 1;
            } else if x > 0 && y > 0 && !visited[x-2][y-1] {
                next_x = x - 2;
                next_y = y - 1;
            } else {
                return false;
            }
            x = next_x;
            y = next_y;
        }
        true
    }
}