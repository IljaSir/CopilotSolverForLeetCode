impl Solution {
    pub fn unique_paths_iii(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut start = (0, 0);
        let mut end = (0, 0);
        let mut empty = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if grid[i][j] == 1 {
                    start = (i, j);
                } else if grid[i][j] == 2 {
                    end = (i, j);
                } else if grid[i][j] == 0 {
                    empty += 1;
                }
            }
        }
        fn dfs(grid: &Vec<Vec<i32>>, visited: &mut Vec<Vec<bool>>, start: (usize, usize), end: (usize, usize), empty: i32, ans: &mut i32) {
            if start == end && empty == 0 {
                *ans += 1;
            }
            let directions = vec![(0, 1), (0, -1), (1, 0), (-1, 0)];
            for d in directions {
                let next = (start.0 as i32 + d.0, start.1 as i32 + d.1);
                if next.0 >= 0 && next.0 < grid.len() as i32 && next.1 >= 0 && next.1 < grid[0].len() as i32 && !visited[next.0 as usize][next.1 as usize] && grid[next.0 as usize][next.1 as usize] != -1 {
                    visited[next.0 as usize][next.1 as usize] = true;
                    dfs(grid, visited, (next.0 as usize, next.1 as usize), end, empty - 1, ans);
                    visited[next.0 as usize][next.1 as usize] = false;
                }
            }
        }
        visited[start.0][start.1] = true;
        dfs(&grid, &mut visited, start, end, empty, &mut ans);
        ans
    }
}