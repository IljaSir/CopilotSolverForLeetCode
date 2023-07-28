impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let mut g = vec![vec![]; n as usize];
        for e in edges {
            g[e[0] as usize - 1].push((e[1] as usize - 1, time));
            g[e[1] as usize - 1].push((e[0] as usize - 1, time));
        }
        let mut dp = vec![std::i32::MAX; n as usize];
        let mut q = std::collections::BinaryHeap::new();
        q.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((t, u))) = q.pop() {
            if dp[u] <= t {
                continue;
            }
            dp[u] = t;
            for &(v, c) in &g[u] {
                let t = t + c + if (t / change) % 2 == 0 { 0 } else { change - t % change };
                q.push(std::cmp::Reverse((t, v)));
            }
        }
        let mut ans = std::i32::MAX;
        for &t in &dp {
            if t > dp[0] {
                ans = ans.min(t);
            }
        }
        ans
    }
}