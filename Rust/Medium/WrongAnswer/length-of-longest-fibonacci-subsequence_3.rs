impl Solution {
    pub fn len_longest_fib_subseq(arr: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; arr.len()]; arr.len()];
        let mut result = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..arr.len() {
            map.insert(arr[i], i);
        }
        for i in 2..arr.len() {
            for j in 1..i {
                let k = map.get(&(arr[i] - arr[j]));
                if let Some(k) = k {
                    if *k < j {
                        dp[i][j] = dp[j][*k] + 1;
                        result = result.max(dp[i][j]);
                    }
                }
            }
        }
        result
    }
}