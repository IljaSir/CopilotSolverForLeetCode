impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result: i32 = 0;
        let mut visited: Vec<Vec<bool>> = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] != 0 {
                    let mut visited: Vec<Vec<bool>> = vec![vec![false; grid[0].len()]; grid.len()];
                    let mut temp = 0;
                    Self::dfs(&grid, i, j, &mut visited, &mut temp);
                    result = result.max(temp);
                }
            }
        }
        result
    }
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>, temp: &mut i32) {
        if i >= grid.len() || j >= grid[0].len() || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0 {
            return;
        }
        visited[i][j] = true;
        *temp += grid[i][j];
        Self::dfs(grid, i + 1, j, visited, temp);
        Self::dfs(grid, i - 1, j, visited, temp);
        Self::dfs(grid, i, j + 1, visited, temp);
        Self::dfs(grid, i, j - 1, visited, temp);
        visited[i][j] = false;
        *temp -= grid[i][j];
    }
}