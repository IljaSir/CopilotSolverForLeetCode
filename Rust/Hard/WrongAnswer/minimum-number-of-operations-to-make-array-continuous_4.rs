impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = nums.len() as i32;
        let mut start = 0;
        let mut end = 0;
        while end < nums.len() {
            if nums[end] - nums[start] >= nums.len() as i32 {
                start += 1;
            } else {
                res = res.min(nums.len() as i32 - (end - start + 1) as i32);
                end += 1;
            }
        }
        res
    }
}