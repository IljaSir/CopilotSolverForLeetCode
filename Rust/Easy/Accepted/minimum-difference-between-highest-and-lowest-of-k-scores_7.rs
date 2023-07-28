impl Solution {
    pub fn minimum_difference(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let k = k as usize;
        let mut ans = i32::MAX;
        for i in 0..nums.len() - k + 1 {
            ans = ans.min(nums[i + k - 1] - nums[i]);
        }
        ans
    }
}