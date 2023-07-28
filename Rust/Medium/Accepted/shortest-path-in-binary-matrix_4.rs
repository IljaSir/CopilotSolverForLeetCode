impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        use std::collections::VecDeque;
        let n = grid.len();
        if grid[0][0] == 1 || grid[n-1][n-1] == 1 { return -1; }
        let mut q = VecDeque::new();
        q.push_back((0, 0));
        let mut visited = vec![vec![false; n]; n];
        visited[0][0] = true;
        let mut dist = 1;
        while !q.is_empty() {
            let mut next_q = VecDeque::new();
            while let Some((x, y)) = q.pop_front() {
                if x == n - 1 && y == n - 1 {
                    return dist;
                }
                for dx in -1..=1 {
                    for dy in -1..=1 {
                        if dx == 0 && dy == 0 { continue; }
                        let nx = x as i32 + dx;
                        let ny = y as i32 + dy;
                        if nx < 0 || nx >= n as i32 || ny < 0 || ny >= n as i32 { continue; }
                        let nx = nx as usize;
                        let ny = ny as usize;
                        if visited[nx][ny] || grid[nx][ny] == 1 { continue; }
                        visited[nx][ny] = true;
                        next_q.push_back((nx, ny));
                    }
                }
            }
            q = next_q;
            dist += 1;
        }
        -1
    }
}