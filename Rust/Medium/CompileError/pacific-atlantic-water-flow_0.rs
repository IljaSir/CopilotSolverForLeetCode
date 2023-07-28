impl Solution {
    pub fn pacific_atlantic(heights: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let m = heights.len();
        let n = heights[0].len();
        let mut pacific = vec![vec![false; n]; m];
        let mut atlantic = vec![vec![false; n]; m];
        for i in 0..m {
            Self::dfs(&heights, i, 0, m, n, &mut pacific);
            Self::dfs(&heights, i, n - 1, m, n, &mut atlantic);
        }
        for j in 0..n {
            Self::dfs(&heights, 0, j, m, n, &mut pacific);
            Self::dfs(&heights, m - 1, j, m, n, &mut atlantic);
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
    fn dfs(heights: &Vec<Vec<i32>>, i: usize, j: usize, m: usize, n: usize, ocean: &mut Vec<Vec<bool>>) {
        ocean[i][j] = true;
        let dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
        for dir in dirs.iter() {
            let x = i as i32 + dir[0];
            let y = j as i32 + dir[1];
            if x >= 0 && x < m as i32 && y >= 0 && y < n as i32 && heights[i][j] <= heights[x as usize][y as usize] && !ocean[x as usize][y as usize] {
                Self::dfs(heights, x as usize, y as usize, m, n, ocean);
            }
        }