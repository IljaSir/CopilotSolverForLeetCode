impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut q = Vec::new();
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == 1 {
                    q.push((i, j, 0));
                }
            }
        }
        if q.len() == 0 || q.len() == n * n {
            return -1;
        }
        let mut max = 0;
        let dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)];
        while !q.is_empty() {
            let (i, j, d) = q.remove(0);
            for &(di, dj) in &dirs {
                let ni = i as i32 + di;
                let nj = j as i32 + dj;
                if ni < 0 || nj < 0 || ni >= n as i32 || nj >= n as i32 || grid[ni as usize][nj as usize] == 1 {
                    continue;
                }
                grid[ni as usize][nj as usize] = 1;
                max = d + 1;
                q.push((ni as usize, nj as usize, d + 1));
            }
        }
        max
    }
}