impl Solution {
    pub fn len_longest_fib_subseq(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![vec![2; n]; n];
        let mut idx = HashMap::new();
        let mut ans = 0;
        for i in 0..n {
            idx.insert(arr[i], i);
        }
        for i in 0..n {
            for j in i+1..n {
                let k = idx.get(&(arr[j] - arr[i])).unwrap_or(&n);
                if *k < i {
                    dp[i][j] = dp[*k][i] + 1;
                }
                ans = ans.max(dp[i][j]);
            }
        }
        if ans >= 3 {
            ans as i32
        } else {
            0
        }
    }
}