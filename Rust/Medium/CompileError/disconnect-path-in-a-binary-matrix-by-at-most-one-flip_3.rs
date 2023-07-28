impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        visited[0][0] = true;
        let mut count = 0;
        while !queue.is_empty() {
            let mut next = Vec::new();
            for (i, j) in queue {
                if i == m - 1 && j == n - 1 {
                    return true;
                }
                if i < m - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1 {
                    visited[i + 1][j] = true;
                    next.push((i + 1, j));
                }
                if j < n - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1 {
                    visited[i][j + 1] = true;
                    next.push((i, j + 1));
                }
            }
            queue = next;
            count += 1;
            if count > 2 {
                return false;
            }
        }
        false
    }
    pub fn disconnect_path(grid: Vec<Vec<i32>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        visited[0][0] = true;
        let mut count = 0;
        while !queue.is_empty() {
            let mut next = Vec::new();
            for (i, j) in queue {
                if i == m - 1 && j == n - 1 {
                    return true;
                }
                if i < m - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1 {
                    visited[i + 1][j] = true;
                    next.push((i + 1, j));
                }
                if j < n - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1 {
                    visited[i][j + 1] = true;
                    next.push((i,
    }
}