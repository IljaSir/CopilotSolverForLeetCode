impl Solution {
    pub fn minimize_sum(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut n = nums.len();
        for i in 1..n {
            ans += nums[i] - nums[i - 1];
        }
        let mut res = ans;
        for i in 1..n - 1 {
            let mut a = nums[i - 1];
            let mut b = nums[i];
            let mut c = nums[i + 1];
            let mut d = nums[n - 1];
            res = res.min(ans - (c - b) + (c - a));
            res = res.min(ans - (b - a) + (d - b));
        }
        res as i32
    }
}