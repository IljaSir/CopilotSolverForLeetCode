impl Solution {
    pub fn minimum_effort_path(heights: Vec<Vec<i32>>) -> i32 {
        
        let mut left = 0;
        let mut right = 1000000;
        let mut mid = 0;
        let mut visited = vec![vec![false; heights[0].len()]; heights.len()];
        while left < right {
            mid = (left + right) / 2;
            visited = vec![vec![false; heights[0].len()]; heights.len()];
            if Solution::dfs(&heights, mid, 0, 0, &mut visited) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
    
    fn dfs(heights: &Vec<Vec<i32>>, max_diff: i32, x: usize, y: usize, visited: &mut Vec<Vec<bool>>) -> bool {
        if x == heights.len() - 1 && y == heights[0].len() - 1 {
            return true;
        }
        visited[x][y] = true;
        let mut res = false;
        if x > 0 && !visited[x - 1][y] && (heights[x][y] - heights[x - 1][y]).abs() <= max_diff {
            res = Solution::dfs(heights, max_diff, x - 1, y, visited);
        }
        if !res && y > 0 && !visited[x][y - 1] && (heights[x][y] - heights[x][y - 1]).abs() <= max_diff {
            res = Solution::dfs(heights, max_diff, x, y - 1, visited);
        }
        if !res && x < heights.len() - 1 && !visited[x + 1][y] && (heights[x][y] - heights[x + 1][y]).abs() <= max_diff {
            res = Solution::dfs(heights, max_diff, x + 1, y, visited);
        }
        if !res && y < heights[0].len() - 1 && !visited[x][y + 1] && (heights[x][y] - heights[x][y + 1]).abs() <= max_diff {
            res = Solution::dfs(heights, max_diff, x, y + 1, visited);
        }
        res
    }
}