impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        

        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if !visited[i][j] && grid[i][j] == '1' {
                    Self::dfs(&grid, &mut visited, i, j);
                    count += 1;
                }
            }
        }
        count
    }
    fn dfs(grid: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, i: usize, j: usize) {
        if i >= grid.len() || j >= grid[i].len() || i < 0 || j < 0 || visited[i][j] || grid[i][j] != '1' {
            return;
        }
        visited[i][j] = true;
        Self::dfs(grid, visited, i + 1, j);
        Self::dfs(grid, visited, i - 1, j);
        Self::dfs(grid, visited, i, j + 1);
        Self::dfs(grid, visited, i, j - 1);
    }
}