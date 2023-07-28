impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        Self::dfs(&mut image, sr as usize, sc as usize, color, image[sr as usize][sc as usize]);
        image
    }
    fn dfs(image: &mut Vec<Vec<i32>>, sr: usize, sc: usize, color: i32, old_color: i32) {
        if image[sr][sc] != old_color {
            return;
        }
        image[sr][sc] = color;
        if sr > 0 {
            Self::dfs(image, sr - 1, sc, color, old_color);
        }
        if sr < image.len() - 1 {
            Self::dfs(image, sr + 1, sc, color, old_color);
        }
        if sc > 0 {
            Self::dfs(image, sr, sc - 1, color, old_color);
        }
        if sc < image[0].len() - 1 {
            Self::dfs(image, sr, sc + 1, color, old_color);
        }
    }
}