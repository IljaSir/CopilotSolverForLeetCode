impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut pq = std::collections::BinaryHeap::new();
        let mut visited = vec![vec![false; n]; m];
        let mut dist = vec![vec![std::i32::MAX; n]; m];
        dist[0][0] = 0;
        pq.push((0, 0, 0));
        while let Some((d, x, y)) = pq.pop() {
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            if x == m - 1 && y == n - 1 {
                return d;
            }
            for (dx, dy) in &[(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let (nx, ny) = (x as i32 + dx, y as i32 + dy);
                if nx >= 0 && nx < m as i32 && ny >= 0 && ny < n as i32 {
                    let (nx, ny) = (nx as usize, ny as usize);
                    let nd = std::cmp::max(d, grid[nx][ny]);
                    if dist[nx][ny] > nd {
                        dist[nx][ny] = nd;
                        pq.push((nd, nx, ny));
                    }
                }
            }
        }
        -1
    }
}