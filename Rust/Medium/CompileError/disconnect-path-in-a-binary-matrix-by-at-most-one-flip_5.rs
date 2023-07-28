impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut queue = Vec::new();
        queue.push((0, 0));
        let mut visited = vec![vec![false; n]; m];
        visited[0][0] = true;
        let mut found = false;
        while !queue.is_empty() {
            let mut next_queue = Vec::new();
            for (i, j) in queue {
                if i == m - 1 && j == n - 1 {
                    found = true;
                    break;
                }
                if i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == 1 {
                    next_queue.push((i + 1, j));
                    visited[i + 1][j] = true;
                }
                if j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 1 {
                    next_queue.push((i, j + 1));
                    visited[i][j + 1] = true;
                }
            }
            queue = next_queue;
        }
        if !found {
            return true;
        }
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    grid[i][j] = 0;
                    let mut queue = Vec::new();
                    queue.push((0, 0));
                    let mut visited = vec![vec![false; n]; m];
                    visited[0][0] = true;
                    let mut found = false;
                    while !queue.is_empty() {
                        let mut next_queue = Vec::new();
                        for (i, j) in queue {
                            if i == m - 1 && j == n - 1 {
                                found = true;
                                break;
                            }
                            if i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == 1 {
                                next_queue.push((i + 1, j));
                                visited[i + 1][j] = true;
                            }
                            if j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 1 {
                                next_queue.push((i, j + 1));
    }
}