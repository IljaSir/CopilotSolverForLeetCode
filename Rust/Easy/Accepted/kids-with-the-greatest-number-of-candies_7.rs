impl Solution {
    pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
        
        let mut max = 0;
        for i in 0..candies.len() {
            if candies[i] > max {
                max = candies[i];
            }
        }
        let mut result = vec![false; candies.len()];
        for i in 0..candies.len() {
            if candies[i] + extra_candies >= max {
                result[i] = true;
            }
        }
        result
    }
}