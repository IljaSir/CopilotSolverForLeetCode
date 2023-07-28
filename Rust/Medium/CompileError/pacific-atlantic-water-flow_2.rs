impl Solution {
    pub fn pacific_atlantic(heights: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let m = heights.len();
        let n = heights[0].len();
        let mut pacific = vec![vec![false; n]; m];
        let mut atlantic = vec![vec![false; n]; m];
        for i in 0..m {
            Solution::dfs(&heights, i, 0, &mut pacific);
            Solution::dfs(&heights, i, n-1, &mut atlantic);
        }
        for j in 0..n {
            Solution::dfs(&heights, 0, j, &mut pacific);
            Solution::dfs(&heights, m-1, j, &mut atlantic);
        }
        let mut res = vec![];
        for i in 0..m {
            for j in 0..n {
                if pacific[i][j] && atlantic[i][j] {
                    res.push(vec![i as i32, j as i32]);
                }
            }
        }
        res
    }
    fn dfs(heights: &Vec<Vec<i32>>, i: usize, j: usize, visited: &mut Vec<Vec<bool>>) {
        if visited[i][j] {
            return;
        }
        visited[i][j] = true;
        let m = heights.len();
        let n = heights[0].len();
        let dirs = vec![(-1, 0), (1, 0), (0, -1), (0, 1)];
        for dir in dirs {
            let x = i as i32 + dir.0;
            let y = j as i32 + dir.1;
            if x < 0 || y < 0 || x >= m as i32 || y >= n as i32 {
                continue;
            }
            let x = x as usize;
            let y = y as usize;
            if heights[x][y] >= heights[i][j] {
                Solution::dfs(heights, x, y, visited);
            }
        }