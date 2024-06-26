impl Solution {
    pub fn max_non_overlapping(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut prefix = vec![0];
        let mut dp = vec![0; nums.len()+1];
        let mut res = 0;
        for n in nums {
            prefix.push(prefix.last().unwrap() + n);
        }
        for i in 1..=nums.len() {
            dp[i] = dp[i-1];
            for j in 0..i {
                if prefix[i] - prefix[j] == target {
                    dp[i] = dp[i].max(dp[j]+1);
                    break;
                }
            }
            res = res.max(dp[i]);
        }
        res
    }
}