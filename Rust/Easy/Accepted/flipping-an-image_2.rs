impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut image = image;
        for row in image.iter_mut() {
            row.reverse();
            for i in row.iter_mut() {
                *i ^= 1;
            }
        }
        image
    }
}