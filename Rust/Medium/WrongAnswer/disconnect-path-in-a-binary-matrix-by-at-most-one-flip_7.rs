impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let mut grid = grid;
        let n = grid.len();
        let m = grid[0].len();
        let mut count = 0;
        for i in 0..n {
            for j in 0..m {
                if grid[i][j] == 1 {
                    grid[i][j] = 0;
                    if !Self::is_connected(&grid) {
                        return true;
                    }
                    grid[i][j] = 1;
                    count += 1;
                }
            }
        }
        count >= 2
    }
    pub fn is_connected(grid: &Vec<Vec<i32>>) -> bool {
        let n = grid.len();
        let m = grid[0].len();
        let mut visited = vec![vec![false; m]; n];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0));
        visited[0][0] = true;
        while let Some((x, y)) = q.pop_front() {
            if x == n - 1 && y == m - 1 {
                return true;
            }
            if x + 1 < n && grid[x + 1][y] == 1 && !visited[x + 1][y] {
                q.push_back((x + 1, y));
                visited[x + 1][y] = true;
            }
            if y + 1 < m && grid[x][y + 1] == 1 && !visited[x][y + 1] {
                q.push_back((x, y + 1));
                visited[x][y + 1] = true;
            }
        }
        false
    }
}