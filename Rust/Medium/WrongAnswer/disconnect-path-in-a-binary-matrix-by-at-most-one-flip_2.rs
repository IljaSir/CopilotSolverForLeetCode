impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        visited[0][0] = true;
        while !queue.is_empty() {
            let (i, j) = queue.remove(0);
            if i == m - 1 && j == n - 1 {
                return true;
            }
            if i + 1 < m && !visited[i + 1][j] && grid[i + 1][j] == 1 {
                visited[i + 1][j] = true;
                queue.push((i + 1, j));
            }
            if j + 1 < n && !visited[i][j + 1] && grid[i][j + 1] == 1 {
                visited[i][j + 1] = true;
                queue.push((i, j + 1));
            }
        }
        false
    }
    pub fn disconnect_path(grid: Vec<Vec<i32>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();
        if grid[0][0] == 1 && grid[m - 1][n - 1] == 1 {
            if Solution::is_possible_to_cut_path(grid.clone()) {
                return true;
            }
            for i in 1..m - 1 {
                for j in 1..n - 1 {
                    if grid[i][j] == 0 {
                        let mut grid = grid.clone();
                        grid[i][j] = 1;
                        if !Solution::is_possible_to_cut_path(grid) {
                            return false;
                        }
                    }
                }
            }
            true
        } else {
            false
        }
    }
}