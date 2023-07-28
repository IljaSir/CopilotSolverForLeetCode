impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in 0..nums.len() {
            result.push(nums[i] * nums[i]);
        }
        result.sort();
        result
    }
}