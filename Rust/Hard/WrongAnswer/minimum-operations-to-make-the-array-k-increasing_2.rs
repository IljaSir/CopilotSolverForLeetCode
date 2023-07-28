impl Solution {
    pub fn k_increasing(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut last = 0;
        for i in 1..arr.len() {
            let mut mi = arr[i] - arr[i-1];
            if i as i32 >= k {
                mi = mi.max(arr[i] - arr[last]);
            }
            dp[i] = dp[i-1] + mi;
            if mi > 0 {
                last = i;
            }
        }
        dp[arr.len()-1]
    }
}