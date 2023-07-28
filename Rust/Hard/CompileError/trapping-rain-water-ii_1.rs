impl Solution {
    pub fn trap_rain_water(height_map: Vec<Vec<i32>>) -> i32 {
        
        let m = height_map.len();
        let n = height_map[0].len();
        let mut height_map = height_map;
        let mut visited = vec![vec![false; n]; m];
        let mut queue = std::collections::BinaryHeap::new();
        for i in 0..m {
            for j in 0..n {
                if i == 0 || i == m - 1 || j == 0 || j == n - 1 {
                    queue.push(std::cmp::Reverse((height_map[i][j], i, j)));
                    visited[i][j] = true;
                }
            }
        }
        let mut ans = 0;
        let mut max_height = 0;
        while let Some(std::cmp::Reverse((height, i, j))) = queue.pop() {
            max_height = max_height.max(height);
            for &(x, y) in &[(i as i32 - 1, j), (i as i32 + 1, j), (i, j as i32 - 1), (i, j as i32 + 1)] {
                let x = x as usize;
                let y = y as usize;
                if x >= m || y >= n || visited[x][y] {
                    continue;
                }
                if height_map[x][y] < max_height {
                    ans += max_height - height_map[x][y];
                }
                queue.push(std::cmp::Reverse((height_map[x][y], x, y)));
                visited[x][y] = true;
            }
        }
        ans
    }
}