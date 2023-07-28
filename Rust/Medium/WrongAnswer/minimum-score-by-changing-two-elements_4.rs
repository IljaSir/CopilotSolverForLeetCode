impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut ans = nums[n-1] - nums[0];
        let mut l = 0;
        let mut r = 0;
        let mut max = 0;
        for i in 1..n-1 {
            l = nums[i] - nums[0];
            r = nums[n-1] - nums[i];
            max = std::cmp::max(l, r);
            ans = std::cmp::min(ans, max);
        }
        ans
    }
}