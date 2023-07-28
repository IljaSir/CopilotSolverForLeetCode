impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut sorted = nums.clone();
        sorted.sort();
        for i in 0..nums.len() {
            let mut rotated = nums.clone();
            for j in 0..nums.len() {
                rotated[j] = nums[(j + i) % nums.len()];
            }
            if rotated == sorted {
                return true;
            }
        }
        false
    }
}