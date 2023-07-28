impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut dp = vec![vec![0; 1 << n]; n];
        for i in 0..n {
            dp[i][1 << i] = nums[i];
        }
        for mask in 1..(1 << n) {
            let mut count = 0;
            for i in 0..n {
                if mask & (1 << i) > 0 {
                    count += 1;
                }
            }
            if count % 2 != 0 {
                continue;
            }
            for i in 0..n {
                if mask & (1 << i) > 0 {
                    dp[i][mask] = dp[i][mask ^ (1 << i)] + nums[i];
                }
            }
        }
        let mut ans = i32::max_value();
        for i in 0..n {
            for j in 0..n {
                if i != j {
                    let mask = (1 << n) - 1;
                    ans = ans.min((dp[i][mask] - dp[j][mask]).abs());
                }
            }
        }
        ans
    }
}