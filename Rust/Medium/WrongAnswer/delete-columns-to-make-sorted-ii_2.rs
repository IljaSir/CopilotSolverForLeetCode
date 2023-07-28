impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let n = strs.len();
        let m = strs[0].len();
        let mut dp = vec![1; m];
        let mut ans = 0;
        for j in 1..m {
            for i in 0..j {
                let mut ok = true;
                for k in 0..n {
                    if strs[k].as_bytes()[i] > strs[k].as_bytes()[j] {
                        ok = false;
                        break;
                    }
                }
                if ok {
                    dp[j] = dp[j].max(dp[i] + 1);
                }
            }
            ans = ans.max(dp[j]);
        }
        (m - ans) as i32
    }
}