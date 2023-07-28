impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        if n == 1 {
            return arr[0];
        }
        let mut dp1 = vec![0; n];
        let mut dp2 = vec![0; n];
        dp1[0] = arr[0];
        dp2[n-1] = arr[n-1];
        let mut res = arr[0];
        for i in 1..n {
            dp1[i] = std::cmp::max(dp1[i-1] + arr[i], arr[i]);
            res = std::cmp::max(res, dp1[i]);
        }
        for i in (0..n-1).rev() {
            dp2[i] = std::cmp::max(dp2[i+1] + arr[i], arr[i]);
            res = std::cmp::max(res, dp2[i]);
        }
        for i in 1..n-1 {
            res = std::cmp::max(res, dp1[i-1] + dp2[i+1]);
        }
        res
    }
}