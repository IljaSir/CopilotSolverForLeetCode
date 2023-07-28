impl Solution {
    pub fn min_increment_for_unique(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut ans = 0;
        nums.sort();
        for i in 1..nums.len() {
            if nums[i] <= nums[i - 1] {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        ans
    }
}