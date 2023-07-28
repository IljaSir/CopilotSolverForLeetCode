impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut dp = vec![vec![0; 101]; 101];
        let mut res = 0;
        for i in 0..arr.len() {
            for j in i+1..arr.len() {
                let t = target - arr[i] - arr[j];
                if t >= 0 {
                    res = (res + dp[t as usize][arr[i] as usize]) % 1000000007;
                }
            }
            for j in 0..=arr[i] {
                dp[arr[i] as usize][j as usize] += 1;
            }
        }
        res
    }
}