impl Solution {
    pub fn max_sum_after_partitioning(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        for i in 0..arr.len() {
            let mut max = arr[i];
            for j in 1..k+1 {
                if i as i32 - j + 1 >= 0 {
                    max = std::cmp::max(max, arr[i-j as usize+1]);
                    dp[i] = std::cmp::max(dp[i], if i as i32 - j >= 0 {dp[i-j as usize]} else {0} + max * j);
                } else {
                    break;
                }
            }
        }
        dp[arr.len()-1]
    }
}