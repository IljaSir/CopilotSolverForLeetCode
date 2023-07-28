impl Solution {
    pub fn nearest_exit(maze: Vec<Vec<char>>, entrance: Vec<i32>) -> i32 {
        
        let m = maze.len();
        let n = maze[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = vec![];
        queue.push((entrance[0] as usize, entrance[1] as usize, 0));
        visited[entrance[0] as usize][entrance[1] as usize] = true;
        while !queue.is_empty() {
            let (i, j, d) = queue.remove(0);
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) && (i != entrance[0] as usize || j != entrance[1] as usize) {
                return d as i32;
            }
            if i > 0 && maze[i - 1][j] == '.' && !visited[i - 1][j] {
                queue.push((i - 1, j, d + 1));
                visited[i - 1][j] = true;
            }
            if i < m - 1 && maze[i + 1][j] == '.' && !visited[i + 1][j] {
                queue.push((i + 1, j, d + 1));
                visited[i + 1][j] = true;
            }
            if j > 0 && maze[i][j - 1] == '.' && !visited[i][j - 1] {
                queue.push((i, j - 1, d + 1));
                visited[i][j - 1] = true;
            }
            if j < n - 1 && maze[i][j + 1] == '.' && !visited[i][j + 1] {
                queue.push((i, j + 1, d + 1));
                visited[i][j + 1] = true;
            }
        }
        -1
    }
}