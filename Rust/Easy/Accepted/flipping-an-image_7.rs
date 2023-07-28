impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        for row in image {
            let mut row = row;
            row.reverse();
            let mut new_row = Vec::new();
            for pixel in row {
                match pixel {
                    0 => new_row.push(1),
                    _ => new_row.push(0),
                }
            }
            result.push(new_row);
        }
        result
    }
}