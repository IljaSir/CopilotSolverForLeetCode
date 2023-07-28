impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        for i in 0..nums.len() {
            if nums[i] % 2 == 0 {
                result.insert(0, nums[i]);
            } else {
                result.push(nums[i]);
            }
        }
        result
    }
}