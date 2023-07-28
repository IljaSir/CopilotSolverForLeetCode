impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let mut grid = grid;
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = vec![(0, 0)];
        let mut path = 0;
        let mut is_possible = false;
        while !queue.is_empty() {
            let mut next_queue = vec![];
            for (i, j) in queue {
                if i == m - 1 && j == n - 1 {
                    is_possible = true;
                    break;
                }
                if i < m - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j] {
                    next_queue.push((i + 1, j));
                    visited[i + 1][j] = true;
                }
                if j < n - 1 && grid[i][j + 1] == 1 && !visited[i][j + 1] {
                    next_queue.push((i, j + 1));
                    visited[i][j + 1] = true;
                }
            }
            if is_possible {
                break;
            }
            if next_queue.is_empty() {
                break;
            }
            if next_queue.len() > 1 {
                return false;
            }
            let (i, j) = next_queue[0];
            if i == m - 1 && j == n - 1 {
                is_possible = true;
                break;
            }
            grid[i][j] = 0;
            visited = vec![vec![false; n]; m];
            queue = vec![(0, 0)];
            path += 1;
            if path > 1 {
                break;
            }
        }
        is_possible
    }
}