impl Solution {
    pub fn height_checker(heights: Vec<i32>) -> i32 {
        
        let mut sorted = heights.clone();
        sorted.sort();
        let mut ans = 0;
        for i in 0..heights.len() {
            if heights[i] != sorted[i] {
                ans += 1;
            }
        }
        ans
    }
}