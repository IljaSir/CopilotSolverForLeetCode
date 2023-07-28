impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let sr = sr as usize;
        let sc = sc as usize;
        let color = color as i32;
        let mut visited = vec![vec![false; image[0].len()]; image.len()];
        let mut q = vec![(sr, sc)];
        let mut from = image[sr][sc];
        visited[sr][sc] = true;
        while !q.is_empty() {
            let (x, y) = q.pop().unwrap();
            image[x][y] = color;
            if x > 0 && !visited[x-1][y] && image[x-1][y] == from {
                q.push((x-1, y));
                visited[x-1][y] = true;
            }
            if x < image.len()-1 && !visited[x+1][y] && image[x+1][y] == from {
                q.push((x+1, y));
                visited[x+1][y] = true;
            }
            if y > 0 && !visited[x][y-1] && image[x][y-1] == from {
                q.push((x, y-1));
                visited[x][y-1] = true;
            }
            if y < image[0].len()-1 && !visited[x][y+1] && image[x][y+1] == from {
                q.push((x, y+1));
                visited[x][y+1] = true;
            }
        }
        image
    }
}