impl Solution {
    pub fn minimum_obstacles(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0, 0));
        while let Some((x, y, step)) = q.pop_front() {
            if x == m - 1 && y == n - 1 {
                return step;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            for &(dx, dy) in &[(1, 0), (0, 1), (-1, 0), (0, -1)] {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx >= 0 && nx < m as i32 && ny >= 0 && ny < n as i32 {
                    if grid[nx as usize][ny as usize] == 1 {
                        q.push_back((nx as usize, ny as usize, step + 1));
                    } else {
                        q.push_front((nx as usize, ny as usize, step));
                    }
                }
            }
        }
        0
    }
}