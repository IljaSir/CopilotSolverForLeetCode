impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut dp = vec![vec![-1; 4001]; 2];
        let mut forbidden = forbidden;
        forbidden.sort();
        dp[0][0] = 0;
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        while !queue.is_empty() {
            let (i, j) = queue.pop_front().unwrap();
            let mut next = j + a;
            if next < 4001 && dp[i][next] == -1 && forbidden.binary_search(&next).is_err() {
                dp[i][next] = dp[i][j] + 1;
                queue.push_back((i, next));
            }
            if i == 0 && j >= b {
                next = j - b;
                if next < 4001 && dp[1][next] == -1 && forbidden.binary_search(&next).is_err() {
                    dp[1][next] = dp[i][j] + 1;
                    queue.push_back((1, next));
                }
            }
        }
        dp.iter().flatten().filter(|&&v| v != -1).min().unwrap_or(-1)
    }
}