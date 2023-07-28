impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let mut dp = vec![1; arr.len()];
        let mut arr = arr;
        arr.push(0);
        arr.push(0);
        let mut idx = vec![0; arr.len()];
        for i in 0..arr.len() {
            idx[i] = i;
        }
        idx.sort_by_key(|&i| arr[i]);
        for i in 0..idx.len() {
            let i = idx[i];
            if i == 0 || i == arr.len() - 1 {
                continue;
            }
            for j in 1..=d {
                if arr[i - j as usize] < arr[i] {
                    dp[i - j as usize] = dp[i - j as usize].max(dp[i] + 1);
                } else {
                    break;
                }
            }
            for j in 1..=d {
                if arr[i + j as usize] < arr[i] {
                    dp[i + j as usize] = dp[i + j as usize].max(dp[i] + 1);
                } else {
                    break;
                }
            }
        }
        dp.into_iter().max().unwrap()
    }
}