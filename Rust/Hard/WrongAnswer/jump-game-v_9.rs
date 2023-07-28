impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut j = 0;
        let mut res = 0;
        while j < arr.len() {
            let mut i = j;
            while i > 0 && arr[i-1] < arr[i] {
                i -= 1;
            }
            while i < j {
                dp[i] = 1;
                i += 1;
            }
            i = j + 1;
            while i < arr.len() && arr[i-1] < arr[i] {
                i += 1;
            }
            while i > j + 1 {
                dp[i-1] = 1;
                i -= 1;
            }
            j = i;
        }
        
        for i in 0..arr.len() {
            if dp[i] == 1 {
                let mut j = 1;
                let mut k = 1;
                while j <= d as usize && i+j < arr.len() && arr[i+j] < arr[i] {
                    dp[i+j] = dp[i+j].max(dp[i] + 1);
                    j += 1;
                }
                while k <= d as usize && i >= k && arr[i-k] < arr[i] {
                    dp[i-k] = dp[i-k].max(dp[i] + 1);
                    k += 1;
                }
            }
            res = res.max(dp[i]);
        }
        res
    }
}