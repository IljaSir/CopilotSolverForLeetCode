impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        if grid[0][0] == 1 || grid[n-1][n-1] == 1 {
            return -1;
        }
        let mut queue = Vec::new();
        let mut visited = vec![vec![false; n]; n];
        queue.push((0, 0));
        visited[0][0] = true;
        let mut step = 1;
        while !queue.is_empty() {
            let mut new_queue = Vec::new();
            for (i, j) in queue {
                if i == n-1 && j == n-1 {
                    return step;
                }
                for (di, dj) in [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)].iter() {
                    let (ni, nj) = (i as i32 + di, j as i32 + dj);
                    if ni >= 0 && nj >= 0 && ni < n as i32 && nj < n as i32 {
                        let (ni, nj) = (ni as usize, nj as usize);
                        if !visited[ni][nj] && grid[ni][nj] == 0 {
                            visited[ni][nj] = true;
                            new_queue.push((ni, nj));
                        }
                    }
                }
            }
            step += 1;
            queue = new_queue;
        }
        -1
    }
}