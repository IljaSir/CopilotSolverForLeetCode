impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut queue = Vec::new();
        let mut visited = vec![vec![false; grid.len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] == 1 {
                    queue.push((i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        if queue.len() == 0 || queue.len() == grid.len() * grid.len() {
            return -1;
        }
        let mut max = 0;
        while queue.len() > 0 {
            let (i, j, dist) = queue.remove(0);
            max = dist;
            if i > 0 && !visited[i - 1][j] {
                queue.push((i - 1, j, dist + 1));
                visited[i - 1][j] = true;
            }
            if i < grid.len() - 1 && !visited[i + 1][j] {
                queue.push((i + 1, j, dist + 1));
                visited[i + 1][j] = true;
            }
            if j > 0 && !visited[i][j - 1] {
                queue.push((i, j - 1, dist + 1));
                visited[i][j - 1] = true;
            }
            if j < grid.len() - 1 && !visited[i][j + 1] {
                queue.push((i, j + 1, dist + 1));
                visited[i][j + 1] = true;
            }
        }
        max
    }
}