impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut q = std::collections::VecDeque::new();
        let mut fresh = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 2 {
                    q.push_back((i, j));
                } else if grid[i][j] == 1 {
                    fresh += 1;
                }
            }
        }
        let mut minutes = 0;
        while !q.is_empty() {
            let mut nq = std::collections::VecDeque::new();
            while let Some((i, j)) = q.pop_front() {
                let dirs = vec![(-1, 0), (1, 0), (0, -1), (0, 1)];
                for (di, dj) in dirs {
                    let ni = i as i32 + di;
                    let nj = j as i32 + dj;
                    if ni >= 0 && ni < grid.len() as i32 && nj >= 0 && nj < grid[ni as usize].len() as i32 {
                        let ni = ni as usize;
                        let nj = nj as usize;
                        if grid[ni][nj] == 1 {
                            grid[ni][nj] = 2;
                            fresh -= 1;
                            nq.push_back((ni, nj));
                        }
                    }
                }
            }
            if !nq.is_empty() {
                minutes += 1;
                q = nq;
            }
        }
        if fresh > 0 {
            return -1;
        }
        minutes
    }
}