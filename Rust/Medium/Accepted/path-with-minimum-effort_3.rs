impl Solution {
    pub fn minimum_effort_path(heights: Vec<Vec<i32>>) -> i32 {
        
        let mut left = 0;
        let mut right = 1_000_000;
        while left < right {
            let mid = (left + right) / 2;
            if Solution::dfs(&heights, mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
    fn dfs(heights: &Vec<Vec<i32>>, mid: i32) -> bool {
        let m = heights.len();
        let n = heights[0].len();
        let mut visited = vec![vec![false; n]; m];
        visited[0][0] = true;
        let mut stack = vec![(0, 0)];
        while !stack.is_empty() {
            let (i, j) = stack.pop().unwrap();
            if i == m - 1 && j == n - 1 {
                return true;
            }
            for (di, dj) in &[(0, 1), (0, -1), (1, 0), (-1, 0)] {
                let ni = i as i32 + di;
                let nj = j as i32 + dj;
                if ni >= 0 && ni < m as i32 && nj >= 0 && nj < n as i32 {
                    let ni = ni as usize;
                    let nj = nj as usize;
                    if !visited[ni][nj] && (heights[i][j] - heights[ni][nj]).abs() <= mid {
                        visited[ni][nj] = true;
                        stack.push((ni, nj));
                    }
                }
            }
        }
        false
    }
}