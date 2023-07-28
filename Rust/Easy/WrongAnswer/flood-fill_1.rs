impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let sr = sr as usize;
        let sc = sc as usize;
        let color = color as u16;
        let m = image.len();
        let n = image[0].len();
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((sr, sc));
        let mut visited = vec![vec![false; n]; m];
        while let Some((r, c)) = queue.pop_front() {
            if visited[r][c] {
                continue;
            }
            visited[r][c] = true;
            image[r][c] = color as i32;
            if r > 0 && image[r - 1][c] == image[sr][sc] as i32 {
                queue.push_back((r - 1, c));
            }
            if r < m - 1 && image[r + 1][c] == image[sr][sc] as i32 {
                queue.push_back((r + 1, c));
            }
            if c > 0 && image[r][c - 1] == image[sr][sc] as i32 {
                queue.push_back((r, c - 1));
            }
            if c < n - 1 && image[r][c + 1] == image[sr][sc] as i32 {
                queue.push_back((r, c + 1));
            }
        }
        image
    }
}