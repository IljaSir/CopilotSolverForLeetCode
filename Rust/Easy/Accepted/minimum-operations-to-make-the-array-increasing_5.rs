impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut pre = nums[0];
        for i in 1..nums.len() {
            if nums[i] <= pre {
                ans += pre + 1 - nums[i];
                pre += 1;
            } else {
                pre = nums[i];
            }
        }
        ans
    }
}