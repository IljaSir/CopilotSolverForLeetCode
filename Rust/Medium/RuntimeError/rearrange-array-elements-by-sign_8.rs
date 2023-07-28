impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = nums.len() - 1;
        loop {
            if i == j {
                result.push(nums[i]);
                break;
            }
            result.push(nums[i]);
            result.push(nums[j]);
            i += 1;
            j -= 1;
        }
        result
    }
}