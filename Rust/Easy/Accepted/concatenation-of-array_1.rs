impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in 0..nums.len() {
            result.push(nums[i]);
        }
        for i in 0..nums.len() {
            result.push(nums[i]);
        }
        result
    }
}