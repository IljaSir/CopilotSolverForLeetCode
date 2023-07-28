impl Solution {
    pub fn swim_in_water(grid: Vec<Vec<i32>>) -> i32 {
        
        let n = grid.len();
        let mut low = 0;
        let mut high = n * n - 1;
        while low < high {
            let mid = low + (high - low) / 2;
            if Solution::can_reach(&grid, mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        low
    }
    
    fn can_reach(grid: &Vec<Vec<i32>>, t: i32) -> bool {
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        let mut queue = Vec::new();
        queue.push((0, 0));
        visited[0][0] = true;
        while !queue.is_empty() {
            let (x, y) = queue.remove(0);
            if x == n - 1 && y == n - 1 {
                return true;
            }
            let dirs = vec![(0, 1), (0, -1), (1, 0), (-1, 0)];
            for (dx, dy) in dirs {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx >= 0 && nx < n as i32 && ny >= 0 && ny < n as i32 && !visited[nx as usize][ny as usize] && grid[nx as usize][ny as usize] <= t {
                    queue.push((nx as usize, ny as usize));
                    visited[nx as usize][ny as usize] = true;
                }
            }
        }
        false
    }
}