impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let mut dir = vec![(1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1), (-1, 2)];
        let mut n = grid.len();
        let mut m = grid[0].len();
        let mut visited = vec![vec![false; m]; n];
        let mut cur = (0, 0);
        for i in 0..n * m {
            visited[cur.0][cur.1] = true;
            let mut found = false;
            for j in 0..8 {
                let nx = cur.0 as i32 + dir[j].0;
                let ny = cur.1 as i32 + dir[j].1;
                if nx < 0 || nx >= n as i32 || ny < 0 || ny >= m as i32 {
                    continue;
                }
                if grid[nx as usize][ny as usize] == i as i32 + 1 {
                    cur = (nx as usize, ny as usize);
                    found = true;
                    break;
                }
            }
            if !found {
                return false;
            }
        }
        return true;
    }
}