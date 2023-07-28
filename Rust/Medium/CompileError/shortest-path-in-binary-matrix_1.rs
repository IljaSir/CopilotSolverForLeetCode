impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        use std::collections::VecDeque;
        let n = grid.len();
        if grid[0][0] == 1 || grid[n-1][n-1] == 1 {
            return -1;
        }
        let mut q = VecDeque::new();
        q.push_back((0, 0, 1));
        while !q.is_empty() {
            let (x, y, d) = q.pop_front().unwrap();
            if x == n-1 && y == n-1 {
                return d as i32;
            }
            for i in -1..=1 {
                for j in -1..=1 {
                    if i == 0 && j == 0 {
                        continue;
                    }
                    let (nx, ny) = (x as i32 + i, y as i32 + j);
                    if nx >= 0 && nx < n as i32 && ny >= 0 && ny < n as i32 && grid[nx as usize][ny as usize] == 0 {
                        q.push_back((nx as usize, ny as usize, d+1));
                        grid[nx as usize][ny as usize] = 1;
                    }
                }
            }
        }
        -1
    }
}