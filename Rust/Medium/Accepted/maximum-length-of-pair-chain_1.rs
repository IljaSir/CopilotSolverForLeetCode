impl Solution {
    pub fn find_longest_chain(pairs: Vec<Vec<i32>>) -> i32 {
        

        let mut pairs = pairs;
        pairs.sort_unstable_by(|a, b| a[0].cmp(&b[0]));
        let mut dp = vec![1; pairs.len()];
        let mut ans = 1;
        for i in 1..pairs.len() {
            for j in 0..i {
                if pairs[j][1] < pairs[i][0] {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            ans = ans.max(dp[i]);
        }
        ans
    }
}