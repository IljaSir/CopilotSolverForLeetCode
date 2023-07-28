impl Solution {
    pub fn minimum_effort_path(heights: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (heights.len(), heights[0].len());
        let mut left = 0;
        let mut right = 1000000;
        while left < right {
            let mid = left + (right - left) / 2;
            let mut visited = vec![vec![false; n]; m];
            let mut queue = std::collections::VecDeque::new();
            queue.push_back((0, 0));
            while let Some((x, y)) = queue.pop_front() {
                if x == m - 1 && y == n - 1 {
                    break;
                }
                if visited[x][y] {
                    continue;
                }
                visited[x][y] = true;
                if x > 0 && (heights[x][y] - heights[x - 1][y]).abs() <= mid {
                    queue.push_back((x - 1, y));
                }
                if x + 1 < m && (heights[x][y] - heights[x + 1][y]).abs() <= mid {
                    queue.push_back((x + 1, y));
                }
                if y > 0 && (heights[x][y] - heights[x][y - 1]).abs() <= mid {
                    queue.push_back((x, y - 1));
                }
                if y + 1 < n && (heights[x][y] - heights[x][y + 1]).abs() <= mid {
                    queue.push_back((x, y + 1));
                }
            }
            if visited[m - 1][n - 1] {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}