impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut forbidden = forbidden;
        forbidden.sort();
        let mut dp = vec![vec![std::i32::MAX; 2]; x as usize + 1];
        dp[0][0] = 0;
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0));
        while let Some((pos, dir)) = q.pop_front() {
            let pos = pos as usize;
            let mut next = pos + a as usize;
            if next <= x as usize && dp[next][0] == std::i32::MAX {
                if !forbidden.contains(&(next as i32)) {
                    dp[next][0] = dp[pos][dir] + 1;
                    q.push_back((next as i32, 0));
                }
            }
            if dir == 0 && pos >= b as usize {
                next = pos - b as usize;
                if dp[next][1] == std::i32::MAX {
                    if !forbidden.contains(&(next as i32)) {
                        dp[next][1] = dp[pos][dir] + 1;
                        q.push_back((next as i32, 1));
                    }
                }
            }
        }
        let mut ans = std::i32::MAX;
        for i in 0..2 {
            ans = ans.min(dp[x as usize][i]);
        }
        if ans == std::i32::MAX {
            -1
        } else {
            ans
        }
    }
}