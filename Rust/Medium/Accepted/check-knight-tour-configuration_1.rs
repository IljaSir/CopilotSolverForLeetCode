impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        visited[0][0] = true;
        let mut i = 0;
        let mut j = 0;
        let dirs = vec![vec![2, 1], vec![2, -1], vec![1, 2], vec![1, -2], vec![-1, 2], vec![-1, -2], vec![-2, 1], vec![-2, -1]];
        for k in 0..n * n - 1 {
            let mut found = false;
            for dir in &dirs {
                let ni = i as i32 + dir[0];
                let nj = j as i32 + dir[1];
                if ni >= 0 && nj >= 0 && ni < n as i32 && nj < n as i32 {
                    let ni = ni as usize;
                    let nj = nj as usize;
                    if grid[ni][nj] == (k + 1) as i32 {
                        visited[ni][nj] = true;
                        found = true;
                        i = ni;
                        j = nj;
                        break;
                    }
                }
            }
            if !found {
                return false;
            }
        }
        for i in 0..n {
            for j in 0..n {
                if !visited[i][j] {
                    return false;
                }
            }
        }
        true
    }
}