impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let mut row = 0;
        let mut col = 0;
        let mut moves = 0;
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        while moves < n * n {
            let r = grid[row][col] / n as i32;
            let c = grid[row][col] % n as i32;
            if visited[r as usize][c as usize] {
                return false;
            }
            visited[r as usize][c as usize] = true;
            moves += 1;
            row = r as usize;
            col = c as usize;
        }
        true
    }
}