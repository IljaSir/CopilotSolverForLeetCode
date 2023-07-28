impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let (sr, sc) = (sr as usize, sc as usize);
        let (m, n) = (image.len(), image[0].len());
        let color2 = image[sr][sc];
        let mut stack = vec![(sr, sc)];
        while !stack.is_empty() {
            let (i, j) = stack.pop().unwrap();
            if image[i][j] == color2 {
                image[i][j] = color;
                if i > 0 { stack.push((i-1, j)); }
                if i < m-1 { stack.push((i+1, j)); }
                if j > 0 { stack.push((i, j-1)); }
                if j < n-1 { stack.push((i, j+1)); }
            }
        }
        image
    }
}