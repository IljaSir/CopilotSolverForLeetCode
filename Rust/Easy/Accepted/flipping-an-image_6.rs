impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        image.iter().map(|row| {
            let mut result = row.clone();
            result.reverse();
            result.iter().map(|&x| 1 - x).collect::<Vec<i32>>()
        }).collect::<Vec<Vec<i32>>>()
    }
}