impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut q: Vec<(i32, i32)> = Vec::new();
        let mut visited = vec![vec![false; grid.len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] == 1 {
                    q.push((i as i32, j as i32));
                    visited[i][j] = true;
                }
            }
        }
        if q.len() == 0 || q.len() == grid.len() * grid.len() {
            return -1;
        }
        let mut distance = -1;
        let mut dirs = vec![(0, 1), (0, -1), (1, 0), (-1, 0)];
        while q.len() > 0 {
            let mut next: Vec<(i32, i32)> = Vec::new();
            for (x, y) in q {
                for (dx, dy) in &dirs {
                    let new_x = x + dx;
                    let new_y = y + dy;
                    if new_x >= 0 && new_x < grid.len() as i32 && new_y >= 0 && new_y < grid.len() as i32 && !visited[new_x as usize][new_y as usize] {
                        next.push((new_x, new_y));
                        visited[new_x as usize][new_y as usize] = true;
                    }
                }
            }
            distance += 1;
            q = next;
        }
        distance
    }
}