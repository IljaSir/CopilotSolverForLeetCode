impl Solution {
    pub fn count_triplets(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n + 1];
        for i in 0..n {
            dp[i + 1] = dp[i] ^ arr[i];
        }
        let mut ans = 0;
        for i in 0..n {
            for j in i + 1..n {
                for k in j..n {
                    if dp[i] == dp[k + 1] {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
}