impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        let mut x = 0;
        let mut y = 0;
        let mut i = 1;
        while i < n * n {
            visited[x][y] = true;
            let mut found = false;
            for dx in -2..3 {
                for dy in -2..3 {
                    if dx.abs() + dy.abs() == 3 {
                        let nx = x as i32 + dx;
                        let ny = y as i32 + dy;
                        if nx >= 0 && nx < n as i32 && ny >= 0 && ny < n as i32 {
                            if grid[nx as usize][ny as usize] == i as i32 {
                                x = nx as usize;
                                y = ny as usize;
                                i += 1;
                                found = true;
                                break;
                            }
                        }
                    }
                }
                if found {
                    break;
                }
            }
            if !found {
                return false;
            }
        }
        true
    }
}