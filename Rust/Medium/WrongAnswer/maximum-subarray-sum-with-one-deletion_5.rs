impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = arr[0];
        let mut dp = vec![0; arr.len()];
        for i in 0..arr.len() {
            sum += arr[i];
            max = max.max(sum);
            if sum < 0 {
                sum = 0;
            }
            dp[i] = max;
        }
        sum = 0;
        max = arr[arr.len() - 1];
        let mut result = max;
        for i in (1..arr.len()).rev() {
            sum += arr[i];
            max = max.max(sum);
            if sum < 0 {
                sum = 0;
            }
            result = result.max(max + dp[i - 1]);
        }
        result
    }
}