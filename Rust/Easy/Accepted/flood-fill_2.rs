impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let (sr, sc) = (sr as usize, sc as usize);
        let (m, n) = (image.len(), image[0].len());
        let old_color = image[sr][sc];
        if old_color == color {
            return image;
        }
        let mut stack = vec![(sr, sc)];
        while let Some((i, j)) = stack.pop() {
            image[i][j] = color;
            if i > 0 && image[i - 1][j] == old_color {
                stack.push((i - 1, j));
            }
            if i + 1 < m && image[i + 1][j] == old_color {
                stack.push((i + 1, j));
            }
            if j > 0 && image[i][j - 1] == old_color {
                stack.push((i, j - 1));
            }
            if j + 1 < n && image[i][j + 1] == old_color {
                stack.push((i, j + 1));
            }
        }
        image
    }
}