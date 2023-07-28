impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        image
            .into_iter()
            .map(|mut row| {
                row.reverse();
                row.into_iter().map(|x| 1 - x).collect()
            })
            .collect()
    }
}