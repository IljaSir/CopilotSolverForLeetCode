impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        if grid[0][0] == 1 || grid[n-1][n-1] == 1 {
            return -1;
        }
        let mut queue = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; n]; n];
        queue.push_back((0, 0));
        visited[0][0] = true;
        let mut step = 1;
        while !queue.is_empty() {
            let len = queue.len();
            for _ in 0..len {
                let (x, y) = queue.pop_front().unwrap();
                if x == n - 1 && y == n - 1 {
                    return step;
                }
                for i in -1..=1 {
                    for j in -1..=1 {
                        if i == 0 && j == 0 {
                            continue;
                        }
                        let nx = x as i32 + i;
                        let ny = y as i32 + j;
                        if nx < 0 || nx >= n as i32 || ny < 0 || ny >= n as i32 {
                            continue;
                        }
                        let nx = nx as usize;
                        let ny = ny as usize;
                        if grid[nx][ny] == 1 || visited[nx][ny] {
                            continue;
                        }
                        queue.push_back((nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            step += 1;
        }
        -1
    }
}