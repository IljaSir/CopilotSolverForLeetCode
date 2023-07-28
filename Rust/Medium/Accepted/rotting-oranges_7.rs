impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut grid = grid;
        let mut q = Vec::new();
        let mut fresh = 0;
        let mut minutes = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    fresh += 1;
                }
                if grid[i][j] == 2 {
                    q.push((i as i32, j as i32));
                }
            }
        }
        while !q.is_empty() {
            let mut q2 = Vec::new();
            for (i, j) in q {
                for (i2, j2) in vec![(i-1, j), (i+1, j), (i, j-1), (i, j+1)] {
                    if i2 >= 0 && i2 < m as i32 && j2 >= 0 && j2 < n as i32 && grid[i2 as usize][j2 as usize] == 1 {
                        grid[i2 as usize][j2 as usize] = 2;
                        fresh -= 1;
                        q2.push((i2, j2));
                    }
                }
            }
            if !q2.is_empty() {
                minutes += 1;
            }
            q = q2;
        }
        if fresh == 0 {
            minutes
        } else {
            -1
        }
    }
}