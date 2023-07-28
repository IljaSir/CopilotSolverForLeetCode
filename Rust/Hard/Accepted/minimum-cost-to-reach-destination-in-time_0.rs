impl Solution {
    pub fn min_cost(max_time: i32, edges: Vec<Vec<i32>>, passing_fees: Vec<i32>) -> i32 {
        
        let n = passing_fees.len();
        let mut g = vec![vec![]; n];
        for e in edges {
            g[e[0] as usize].push((e[1] as usize, e[2]));
            g[e[1] as usize].push((e[0] as usize, e[2]));
        }
        let mut dp = vec![vec![i32::MAX; n]; max_time as usize + 1];
        dp[0][0] = passing_fees[0];
        for t in 0..max_time as usize {
            for i in 0..n {
                if dp[t][i] == i32::MAX {
                    continue;
                }
                for &(j, time) in &g[i] {
                    let t2 = t + time as usize;
                    if t2 <= max_time as usize {
                        dp[t2][j] = dp[t2][j].min(dp[t][i] + passing_fees[j]);
                    }
                }
            }
        }
        let mut ans = i32::MAX;
        for t in 0..=max_time as usize {
            ans = ans.min(dp[t][n - 1]);
        }
        if ans == i32::MAX {
            -1
        } else {
            ans
        }
    }
}