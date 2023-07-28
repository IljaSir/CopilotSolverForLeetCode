impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0;n];
        let mut sum = 0;
        let mut max = 0;
        for i in 0..n {
            sum += arr[i];
            sum = sum.max(0);
            max = max.max(sum);
            dp[i] = max;
        }
        sum = 0;
        max = 0;
        for i in (0..n).rev() {
            sum += arr[i];
            sum = sum.max(0);
            max = max.max(sum);
            dp[i] += max;
        }
        dp.iter().max().unwrap().max(0) as i32 + (k-1).max(0) as i32 * dp.iter().sum::<i32>() as i32
    }
}