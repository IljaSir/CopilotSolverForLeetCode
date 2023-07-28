impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        visited[0][0] = true;
        let mut res = false;
        while !queue.is_empty() {
            let (x, y) = queue.remove(0);
            if x == m - 1 && y == n - 1 {
                res = true;
                break;
            }
            let c = grid[x][y];
            for (i, j) in [(x, y + 1), (x, y - 1), (x + 1, y), (x - 1, y)].iter() {
                if *i >= 0 && *i < m && *j >= 0 && *j < n && !visited[*i][*j] {
                    match grid[*i][*j] {
                        '(' => {
                            if c == '(' || c == ' ' {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        ')' => {
                            if c == ')' || c == ' ' {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        '-' => {
                            if c == '-' || c == ' ' {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        '|' => {
                            if c == '|' || c == ' ' {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        ' ' => {
                            queue.push((*i, *j));
                            visited[*i][*j] = true;
                        }
                        '/' => {
                            if (c == '(' && *j > y) || (c == ')' && *j < y) {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        '\\' => {
                            if (c == '(' && *j < y) || (c == ')' && *j > y) {
                                queue.push((*i, *j));
                                visited[*i][*j] = true;
                            }
                        }
                        _ =>
    }
}