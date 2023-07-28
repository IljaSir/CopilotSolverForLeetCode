impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, color: i32) -> Vec<Vec<i32>> {
        
        let mut image = image;
        let sr = sr as usize;
        let sc = sc as usize;
        let color = color as usize;
        let old_color = image[sr][sc] as usize;
        let m = image.len();
        let n = image[0].len();
        let mut stack = vec![(sr, sc)];
        while !stack.is_empty() {
            let (r, c) = stack.pop().unwrap();
            if image[r][c] == old_color as i32 {
                image[r][c] = color as i32;
                if r > 0 {
                    stack.push((r - 1, c));
                }
                if r < m - 1 {
                    stack.push((r + 1, c));
                }
                if c > 0 {
                    stack.push((r, c - 1));
                }
                if c < n - 1 {
                    stack.push((r, c + 1));
                }
            }
        }
        image
    }
}