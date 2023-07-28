impl Solution {
    pub fn len_longest_fib_subseq(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![vec![0; n]; n];
        let mut ans = 0;
        let mut m = std::collections::HashMap::new();
        for i in 0..n {
            m.insert(arr[i], i);
        }
        for i in 0..n {
            for j in i + 1..n {
                if let Some(k) = m.get(&(arr[j] - arr[i])) {
                    if *k < i {
                        dp[i][j] = dp[*k][i] + 1;
                        ans = ans.max(dp[i][j]);
                    }
                }
            }
        }
        ans
    }
}