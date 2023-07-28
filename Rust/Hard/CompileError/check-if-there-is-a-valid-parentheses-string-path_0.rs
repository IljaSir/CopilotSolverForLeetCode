impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0));
        visited[0][0] = true;
        while !q.is_empty() {
            let (x, y) = q.pop_front().unwrap();
            if x == m - 1 && y == n - 1 {
                return true;
            }
            let c = grid[x][y];
            let mut dir = vec![];
            match c {
                '(' => dir = vec![(0, 1), (1, 0)],
                ')' => dir = vec![(0, -1), (-1, 0)],
                '*' => dir = vec![(0, 1), (1, 0), (0, -1), (-1, 0)],
                '|' => dir = vec![(1, 0), (-1, 0)],
                '-' => dir = vec![(0, 1), (0, -1)],
                _ => {}
            }
            for (dx, dy) in dir {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx < 0 || nx >= m as i32 || ny < 0 || ny >= n as i32 {
                    continue;
                }
                let nx = nx as usize;
                let ny = ny as usize;
                if visited[nx][ny] {
                    continue;
                }
                let nc = grid[nx][ny];
                if (dx == 0 && dy == 1 && nc == '(') || (dx == 1 && dy == 0 && nc == '|') || (dx == 0 && dy == -1 && nc == ')') || (dx == -1 && dy == 0 && nc == '|') {
                    visited[nx][ny] = true;
                    q.push_back((nx, ny));
                }
                if (dx == 0 && dy == -1 && nc == '(') || (dx == 1 && dy == 0 && nc == '-') || (dx == 0 && dy == 1 && nc == ')') || (dx == -1 && dy == 0 && nc == '-') {
    }
}