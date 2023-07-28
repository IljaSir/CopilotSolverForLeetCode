impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let k = k as usize;
        let mut dp = vec![std::i32::MAX; n];
        let mut edges = vec![vec![]; n];
        for time in times {
            edges[time[0] as usize - 1].push((time[1] as usize - 1, time[2]));
        }
        let mut queue = std::collections::BinaryHeap::new();
        queue.push((0, k - 1));
        while let Some((cost, cur)) = queue.pop() {
            if dp[cur] > cost {
                dp[cur] = cost;
                for (next, time) in &edges[cur] {
                    queue.push((cost - time, *next));
                }
            }
        }
        let mut res = 0;
        for i in 0..n {
            if dp[i] == std::i32::MAX {
                return -1;
            }
            res = res.max(dp[i]);
        }
        res
    }
}