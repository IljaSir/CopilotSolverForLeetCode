impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![1; n];
        let mut ans = 1;
        let mut arr = arr;
        arr.push(0);
        let mut stack = vec![];
        for i in 0..n {
            while !stack.is_empty() && arr[i] > arr[stack[stack.len() - 1]] {
                let j = stack.pop().unwrap();
                let left = if stack.is_empty() { 0 } else { stack[stack.len() - 1] + 1 };
                let right = if i < n { i } else { n - 1 };
                if right - left + 1 <= d as usize {
                    dp[i] = dp[i].max(dp[j] + right - left + 1);
                } else {
                    dp[i] = dp[i].max(dp[j] + d);
                    if left + d as usize <= right {
                        dp[left + d as usize] = dp[left + d as usize].max(dp[j] + right - left - d as usize + 1);
                    }
                }
            }
            stack.push(i);
        }
        for i in 0..n {
            ans = ans.max(dp[i]);
        }
        ans
    }
}