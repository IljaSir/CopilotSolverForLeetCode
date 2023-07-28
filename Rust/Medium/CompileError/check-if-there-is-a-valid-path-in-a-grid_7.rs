impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut visited = vec![vec![false; n]; m];
        fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>) -> bool {
            if i == grid.len() - 1 && j == grid[0].len() - 1 {
                return true;
            }
            visited[i][j] = true;
            let mut res = false;
            let (m, n) = (grid.len(), grid[0].len());
            let dirs = vec![vec![0, 1], vec![1, 0], vec![0, -1], vec![-1, 0]];
            for dir in dirs {
                let (x, y) = (i as i32 + dir[0], j as i32 + dir[1]);
                if x < 0 || x >= m as i32 || y < 0 || y >= n as i32 {
                    continue;
                }
                let (x, y) = (x as usize, y as usize);
                if visited[x][y] {
                    continue;
                }
                let (a, b) = (grid[i][j], grid[x][y]);
                if (a == 1 && b == 1) || (a == 2 && b == 2) {
                    res |= dfs(grid, x, y, visited);
                } else if (a == 1 && b == 4) || (a == 4 && b == 1) {
                    if dir[0] == 0 {
                        res |= dfs(grid, x, y, visited);
                    }
                } else if (a == 1 && b == 3) || (a == 3 && b == 1) {
                    if dir[0] == 0 {
                        res |= dfs(grid, x, y, visited);
                    }
                } else if (a == 2 && b == 5) || (a == 5 && b == 2) {
                    if dir[1] == 0 {
                        res |= dfs(grid, x, y, visited);
                    }
                } else if (a == 2 && b == 6) || (a == 6 && b == 2) {
                    if dir
    }
}