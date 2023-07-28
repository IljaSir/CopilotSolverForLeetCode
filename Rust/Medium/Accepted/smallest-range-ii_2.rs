impl Solution {
    pub fn smallest_range_ii(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = nums[nums.len() - 1] - nums[0];
        for i in 0..nums.len() - 1 {
            let a = nums[i];
            let b = nums[i + 1];
            let high = std::cmp::max(nums[nums.len() - 1] - k, a + k);
            let low = std::cmp::min(nums[0] + k, b - k);
            ans = std::cmp::min(ans, high - low);
        }
        ans
    }
}