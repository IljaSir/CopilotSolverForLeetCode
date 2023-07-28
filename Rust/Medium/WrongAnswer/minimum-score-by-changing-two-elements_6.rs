impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let n = nums.len();
        nums.sort();
        let mut ans = 1e18 as i64;
        for i in 0..n {
            let mut j = i + 1;
            if j < n {
                ans = ans.min((nums[j] - nums[i]) as i64);
            }
            if j + 1 < n {
                ans = ans.min((nums[j + 1] - nums[i]) as i64);
            }
            if i > 0 {
                ans = ans.min((nums[i] - nums[i - 1]) as i64);
            }
            if i > 1 {
                ans = ans.min((nums[i] - nums[i - 2]) as i64);
            }
        }
        ans as i32
    }
}