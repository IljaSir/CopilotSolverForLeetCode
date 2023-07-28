impl Solution {
    pub fn shortest_path_binary_matrix(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut queue: Vec<(usize, usize)> = Vec::new();
        let mut visited: Vec<Vec<bool>> = Vec::new();
        let mut step = 0;
        let n = grid.len();
        for i in 0..n {
            let mut line: Vec<bool> = Vec::new();
            for j in 0..n {
                line.push(false);
            }
            visited.push(line);
        }
        queue.push((0, 0));
        visited[0][0] = true;
        while queue.len() > 0 {
            step += 1;
            let mut new_queue: Vec<(usize, usize)> = Vec::new();
            for (i, j) in queue {
                if i == n - 1 && j == n - 1 {
                    return step;
                }
                for (x, y) in Self::get_next((i, j), n) {
                    if !visited[x][y] && grid[x][y] == 0 {
                        visited[x][y] = true;
                        new_queue.push((x, y));
                    }
                }
            }
            queue = new_queue;
        }
        -1
    }
    fn get_next((i, j): (usize, usize), n: usize) -> Vec<(usize, usize)> {
        let mut res: Vec<(usize, usize)> = Vec::new();
        if i > 0 {
            res.push((i - 1, j));
        }
        if j > 0 {
            res.push((i, j - 1));
        }
        if i > 0 && j > 0 {
            res.push((i - 1, j - 1));
        }
        if i < n - 1 {
            res.push((i + 1, j));
        }
        if j < n - 1 {
            res.push((i, j + 1));
        }
        if i < n - 1 && j < n - 1 {
            res.push((i + 1, j + 1));
        }
        if i > 0 && j < n - 1 {
            res.push((i - 1, j + 1));
        }
        if i < n - 1 && j > 0 {
            res.push((i + 1, j - 1));
        }
        res
    }
}