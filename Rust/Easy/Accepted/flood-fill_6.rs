impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let color_old = image[sr as usize][sc as usize];
        if color_old == color {
            return image;
        }
        let mut stack = vec![(sr, sc)];
        while !stack.is_empty() {
            let (r, c) = stack.pop().unwrap();
            if image[r as usize][c as usize] == color_old {
                image[r as usize][c as usize] = color;
                if r > 0 {
                    stack.push((r - 1, c));
                }
                if c > 0 {
                    stack.push((r, c - 1));
                }
                if r < image.len() as i32 - 1 {
                    stack.push((r + 1, c));
                }
                if c < image[0].len() as i32 - 1 {
                    stack.push((r, c + 1));
                }
            }
        }
        image
    }
}