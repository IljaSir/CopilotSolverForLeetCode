impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut queue = std::collections::BinaryHeap::new();
        queue.push(std::cmp::Reverse((0, 0, 0)));
        let mut visited = vec![vec![false; n]; m];
        while let Some(std::cmp::Reverse((t, x, y))) = queue.pop() {
            if x == m - 1 && y == n - 1 {
                return t;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            for (dx, dy) in vec![(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx >= 0 && ny >= 0 && nx < m as i32 && ny < n as i32 {
                    let nx = nx as usize;
                    let ny = ny as usize;
                    if visited[nx][ny] {
                        continue;
                    }
                    let nt = t.max(grid[nx][ny]);
                    queue.push(std::cmp::Reverse((nt, nx, ny)));
                }
            }
        }
        -1
    }
}