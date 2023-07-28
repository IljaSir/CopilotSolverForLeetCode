impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        while !queue.is_empty() {
            let (x, y) = queue.pop().unwrap();
            if x == m - 1 && y == n - 1 {
                return true;
            }
            if x + 1 < m && !visited[x + 1][y] && grid[x + 1][y] == 1 {
                queue.push((x + 1, y));
                visited[x + 1][y] = true;
            }
            if y + 1 < n && !visited[x][y + 1] && grid[x][y + 1] == 1 {
                queue.push((x, y + 1));
                visited[x][y + 1] = true;
            }
        }
        false
    }
    
    pub fn disconnect_path(grid: Vec<Vec<i32>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();
        let mut grid2 = grid.clone();
        for i in 0..m {
            for j in 0..n {
                if i == 0 && j == 0 || i == m - 1 && j == n - 1 {
                    continue;
                }
                if grid[i][j] == 1 {
                    grid2[i][j] = 0;
                    if !Solution::is_possible_to_cut_path(grid2.clone()) {
                        return true;
                    }
                    grid2[i][j] = 1;
                }
            }
        }
        false
    }
}