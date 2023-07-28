impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut q = vec![(0, 0)];
        visited[0][0] = true;
        while !q.is_empty() {
            let (i, j) = q.remove(0);
            if i == m - 1 && j == n - 1 {
                return true;
            }
            let dir = grid[i][j];
            let dirs = match dir {
                1 => vec![(0, -1), (0, 1)],
                2 => vec![(-1, 0), (1, 0)],
                3 => vec![(0, -1), (1, 0)],
                4 => vec![(0, 1), (1, 0)],
                5 => vec![(0, -1), (-1, 0)],
                6 => vec![(0, 1), (-1, 0)],
                _ => vec![],
            };
            for (di, dj) in dirs {
                let ni = i as i32 + di;
                let nj = j as i32 + dj;
                if ni < 0 || ni >= m as i32 || nj < 0 || nj >= n as i32 {
                    continue;
                }
                let ni = ni as usize;
                let nj = nj as usize;
                if visited[ni][nj] {
                    continue;
                }
                let ndir = grid[ni][nj];
                let ndirs = match ndir {
                    1 => vec![(0, -1), (0, 1)],
                    2 => vec![(-1, 0), (1, 0)],
                    3 => vec![(0, -1), (-1, 0)],
                    4 => vec![(0, 1), (-1, 0)],
                    5 => vec![(0, -1), (1, 0)],
                    6 => vec![(0, 1), (1, 0)],
                    _ => vec![],
                };
                if !ndirs.contains(&(-di, -dj)) {
                    continue;
                }
                visited[ni][nj] = true;
                q.push((ni, nj));
            }
    }
}