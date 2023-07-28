impl Solution {
    pub fn decompress_rl_elist(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for i in (0..nums.len()).step_by(2) {
            result.extend((0..nums[i]).map(|_| nums[i + 1]));
        }
        result
    }
}