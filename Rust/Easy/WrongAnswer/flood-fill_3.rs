impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let sr = sr as usize;
        let sc = sc as usize;
        let color = color as usize;
        let (m, n) = (image.len(), image[0].len());
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; n]; m];
        let mut dir = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];
        q.push_back((sr, sc));
        visited[sr][sc] = true;
        while !q.is_empty() {
            let (x, y) = q.pop_front().unwrap();
            image[x][y] = color as i32;
            for (dx, dy) in dir.iter() {
                let (nx, ny) = (x as i32 + dx, y as i32 + dy);
                if nx >= 0 && nx < m as i32 && ny >= 0 && ny < n as i32 {
                    let (nx, ny) = (nx as usize, ny as usize);
                    if !visited[nx][ny] && image[nx][ny] == image[sr][sc] {
                        q.push_back((nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        image
    }
}