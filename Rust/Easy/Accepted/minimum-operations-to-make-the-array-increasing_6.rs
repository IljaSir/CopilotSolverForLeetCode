impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut ret = 0;
        let mut pre = nums[0];
        for i in 1..nums.len() {
            if nums[i] <= pre {
                ret += pre - nums[i] + 1;
                pre += 1;
            } else {
                pre = nums[i];
            }
        }
        ret
    }
}