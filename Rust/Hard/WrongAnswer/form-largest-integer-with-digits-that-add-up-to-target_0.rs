impl Solution {
    pub fn largest_number(cost: Vec<i32>, target: i32) -> String {
        
        let mut dp: Vec<i32> = vec![-1; target as usize + 1];
        dp[0] = 0;
        for i in 1..=target {
            for j in 0..9 {
                let prev = i - cost[j];
                if prev >= 0 && dp[prev as usize] >= 0 {
                    dp[i as usize] = std::cmp::max(dp[i as usize], dp[prev as usize] + 1);
                }
            }
        }
        if dp[target as usize] < 0 {
            return "0".to_string();
        }
        let mut ans: Vec<char> = vec![];
        let mut i = target;
        while i > 0 {
            for j in (0..9).rev() {
                let prev = i - cost[j];
                if prev >= 0 && dp[prev as usize] == dp[i as usize] - 1 {
                    ans.push((j + 1) as u8 as char);
                    i = prev;
                    break;
                }
            }
        }
        ans.iter().rev().collect()
    }
}