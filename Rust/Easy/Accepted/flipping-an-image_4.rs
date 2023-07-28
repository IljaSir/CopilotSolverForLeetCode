impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![];
        for row in image {
            let mut new_row = vec![];
            for i in (0..row.len()).rev() {
                new_row.push(if row[i] == 1 { 0 } else { 1 });
            }
            result.push(new_row);
        }
        result
    }
}