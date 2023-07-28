impl Solution {
    pub fn height_checker(heights: Vec<i32>) -> i32 {
        
        let mut heights = heights;
        heights.sort();
        let mut count = 0;
        for i in 0..heights.len() {
            if heights[i] != heights[i] {
                count += 1;
            }
        }
        count
    }
}