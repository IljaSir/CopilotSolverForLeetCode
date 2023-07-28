impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let mut moves = Vec::new();
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                moves.push((i as i32, j as i32));
            }
        }
        let mut x = 0;
        let mut y = 0;
        for m in moves {
            if m.0 == x && m.1 == y {
                continue;
            }
            if m.0 - x == 1 || m.0 - x == -1 {
                if m.1 - y == 2 || m.1 - y == -2 {
                    x = m.0;
                    y = m.1;
                    continue;
                }
            }
            if m.0 - x == 2 || m.0 - x == -2 {
                if m.1 - y == 1 || m.1 - y == -1 {
                    x = m.0;
                    y = m.1;
                    continue;
                }
            }
            return false;
        }
        true
    }
}