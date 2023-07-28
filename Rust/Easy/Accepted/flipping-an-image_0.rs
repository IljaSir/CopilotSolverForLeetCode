impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut image = image;
        for i in 0..image.len() {
            image[i].reverse();
            for j in 0..image[i].len() {
                image[i][j] = 1 - image[i][j];
            }
        }
        image
    }
}