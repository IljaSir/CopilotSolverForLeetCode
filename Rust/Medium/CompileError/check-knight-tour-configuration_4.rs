impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut moves = vec![vec![0; n]; n];
        let mut x = 0;
        let mut y = 0;
        for i in 0..n*n {
            moves[x][y] = 1;
            if i == n*n-1 {
                break;
            }
            let mut found = false;
            if x-1>=0 && y-2>=0 && grid[x-1][y-2]==i as i32+1 {
                x = x-1;
                y = y-2;
                found = true;
            }
            if !found && x-1>=0 && y+2<n && grid[x-1][y+2]==i as i32+1 {
                x = x-1;
                y = y+2;
                found = true;
            }
            if !found && x+1<n && y-2>=0 && grid[x+1][y-2]==i as i32+1 {
                x = x+1;
                y = y-2;
                found = true;
            }
            if !found && x+1<n && y+2<n && grid[x+1][y+2]==i as i32+1 {
                x = x+1;
                y = y+2;
                found = true;
            }
            if !found && x-2>=0 && y-1>=0 && grid[x-2][y-1]==i as i32+1 {
                x = x-2;
                y = y-1;
                found = true;
            }
            if !found && x-2>=0 && y+1<n && grid[x-2][y+1]==i as i32+1 {
                x = x-2;
                y = y+1;
                found = true;
            }
            if !found && x+2<n && y-1>=0 && grid[x+2][y-1]==i as i32+1 {
                x = x+2;
                y = y-1;
                found = true;
            }
            if !found && x+2<n && y+1<n && grid[x+2][y+1]==i as i32+1 {
                x = x+2;
                y = y+1;
                found = true;
    }
}