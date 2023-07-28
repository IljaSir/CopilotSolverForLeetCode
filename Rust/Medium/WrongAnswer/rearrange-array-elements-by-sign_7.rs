impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable_by(|a, b| a.abs().cmp(&b.abs()));
        let mut result = Vec::with_capacity(nums.len());
        let mut i = 0;
        let mut j = nums.len() / 2;
        while i < nums.len() / 2 {
            result.push(nums[i]);
            result.push(nums[j]);
            i += 1;
            j += 1;
        }
        result
    }
}