impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = vec![(0, 0)];
        while queue.len() > 0 {
            let (i, j) = queue.pop().unwrap();
            if i == m - 1 && j == n - 1 {
                return true;
            }
            visited[i][j] = true;
            for (x, y) in Self::next(&grid, i, j) {
                if !visited[x][y] {
                    queue.push((x, y));
                }
            }
        }
        false
    }
    fn next(grid: &Vec<Vec<i32>>, i: usize, j: usize) -> Vec<(usize, usize)> {
        let mut result = vec![];
        let m = grid.len();
        let n = grid[0].len();
        let street = grid[i][j];
        if i > 0 {
            let street2 = grid[i - 1][j];
            if street == 1 && street2 == 1 {
                result.push((i - 1, j));
            } else if street == 4 && street2 == 3 {
                result.push((i - 1, j));
            } else if street == 6 && street2 == 3 {
                result.push((i - 1, j));
            }
        }
        if i < m - 1 {
            let street2 = grid[i + 1][j];
            if street == 1 && street2 == 1 {
                result.push((i + 1, j));
            } else if street == 3 && street2 == 4 {
                result.push((i + 1, j));
            } else if street == 5 && street2 == 4 {
                result.push((i + 1, j));
            }
        }
        if j > 0 {
            let street2 = grid[i][j - 1];
            if street == 2 && street2 == 2 {
                result.push((i, j - 1));
            } else if street == 3 && street2 == 6 {
                result.push((i, j - 1));
            } else if street == 4 && street2 == 5 {
                result.push((i,
    }
}