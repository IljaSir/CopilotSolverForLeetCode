impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut stack = vec![(0, 0)];
        while !stack.is_empty() {
            let (i, j) = stack.pop().unwrap();
            if i == m - 1 && j == n - 1 {
                return true;
            }
            visited[i][j] = true;
            let c = grid[i][j];
            let mut next = vec![];
            if i > 0 && !visited[i - 1][j] {
                match c {
                    '(' | 'A' | 'C' | 'E' | 'G' => {
                        match grid[i - 1][j] {
                            ')' | 'A' | 'B' | 'D' | 'F' => next.push((i - 1, j)),
                            _ => (),
                        }
                    }
                    _ => (),
                }
            }
            if i < m - 1 && !visited[i + 1][j] {
                match c {
                    ')' | 'A' | 'B' | 'D' | 'F' => {
                        match grid[i + 1][j] {
                            '(' | 'A' | 'C' | 'E' | 'G' => next.push((i + 1, j)),
                            _ => (),
                        }
                    }
                    _ => (),
                }
            }
            if j > 0 && !visited[i][j - 1] {
                match c {
                    '(' | 'B' | 'D' | 'F' | 'G' => {
                        match grid[i][j - 1] {
                            ')' | 'B' | 'C' | 'E' | 'G' => next.push((i, j - 1)),
                            _ => (),
                        }
                    }
                    _ => (),
                }
            }
            if j < n - 1 && !visited[i][j + 1] {
                match c {
                    ')' | 'B' | 'C' | 'E' | 'G' => {
                        match grid[i][j + 1] {
                            '(' | 'B' | 'D' | 'F' | 'G' => next.push((i, j + 1)),
                            _ => (),
                        }
                    }