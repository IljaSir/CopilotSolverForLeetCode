impl Solution {
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if !visited[i][j] {
                    if Solution::dfs(&grid, &mut visited, i, j, i, j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    pub fn dfs(grid: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize, last_i: usize, last_j: usize) -> bool {
        if visited[i][j] {
            return true;
        }
        visited[i][j] = true;
        if i > 0 && grid[i - 1][j] == grid[i][j] && !(i - 1 == last_i && j == last_j) {
            if Solution::dfs(grid, visited, i - 1, j, i, j) {
                return true;
            }
        }
        if j > 0 && grid[i][j - 1] == grid[i][j] && !(i == last_i && j - 1 == last_j) {
            if Solution::dfs(grid, visited, i, j - 1, i, j) {
                return true;
            }
        }
        if i < grid.len() - 1 && grid[i + 1][j] == grid[i][j] && !(i + 1 == last_i && j == last_j) {
            if Solution::dfs(grid, visited, i + 1, j, i, j) {
                return true;
            }
        }
        if j < grid[0].len() - 1 && grid[i][j + 1] == grid[i][j] && !(i == last_i && j + 1 == last_j) {
            if Solution::dfs(grid, visited, i, j + 1, i, j) {
                return true;
            }
        }
        return false;
    }
}