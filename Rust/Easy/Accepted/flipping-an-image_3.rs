impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        for row in image {
            let mut row = row;
            row.reverse();
            for i in 0..row.len() {
                if row[i] == 0 {
                    row[i] = 1;
                } else {
                    row[i] = 0;
                }
            }
            result.push(row);
        }
        result
    }
}