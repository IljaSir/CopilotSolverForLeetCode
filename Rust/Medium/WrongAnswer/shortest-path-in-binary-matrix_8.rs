impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut grid = grid;
        let mut queue = Vec::new();
        queue.push((0, 0, 1));
        while !queue.is_empty() {
            let (x, y, d) = queue.remove(0);
            if x == n - 1 && y == n - 1 {
                return d as i32;
            }
            let dirs = vec![
                (0, 1), (0, -1), (1, 0), (-1, 0),
                (1, 1), (1, -1), (-1, 1), (-1, -1),
            ];
            for (dx, dy) in dirs {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx >= 0 && nx < n as i32 && ny >= 0 && ny < n as i32 && grid[nx as usize][ny as usize] == 0 {
                    queue.push((nx as usize, ny as usize, d + 1));
                    grid[nx as usize][ny as usize] = 1;
                }
            }
        }
        -1
    }
}