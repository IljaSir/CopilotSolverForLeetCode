impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut q = std::collections::BinaryHeap::new();
        let mut visited = vec![vec![false; n]; m];
        q.push(std::cmp::Reverse((0, 0, 0)));
        visited[0][0] = true;
        let mut ans = 0;
        while !q.is_empty() {
            let std::cmp::Reverse((t, x, y)) = q.pop().unwrap();
            ans = t;
            if x == m - 1 && y == n - 1 {
                break;
            }
            for &(dx, dy) in &[(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx >= 0 && nx < m as i32 && ny >= 0 && ny < n as i32 {
                    let nx = nx as usize;
                    let ny = ny as usize;
                    if !visited[nx][ny] && t + 1 >= grid[nx][ny] {
                        visited[nx][ny] = true;
                        q.push(std::cmp::Reverse((grid[nx][ny], nx, ny)));
                    }
                }
            }
        }
        if visited[m - 1][n - 1] {
            ans
        } else {
            -1
        }
    }
}