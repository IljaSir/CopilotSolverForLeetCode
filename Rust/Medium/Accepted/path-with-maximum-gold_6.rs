impl Solution {
    pub fn get_maximum_gold(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] > 0 {
                    let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
                    max = max.max(Solution::dfs(&grid, i, j, &mut visited));
                }
            }
        }
        max
    }
    fn dfs(grid: &Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>) -> i32 {
        if i >= grid.len() || j >= grid[0].len() || grid[i][j] == 0 || visited[i][j] {
            return 0;
        }
        visited[i][j] = true;
        let max = grid[i][j] + Solution::dfs(grid, i + 1, j, visited).max(Solution::dfs(grid, i, j + 1, visited).max(Solution::dfs(grid, i, j.checked_sub(1).unwrap_or(0), visited).max(Solution::dfs(grid, i.checked_sub(1).unwrap_or(0), j, visited))));
        visited[i][j] = false;
        max
    }
}