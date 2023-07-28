impl Solution {
    pub fn frog_position(n: i32, edges: Vec<Vec<i32>>, t: i32, target: i32) -> f64 {
        
        let mut adj: Vec<Vec<i32>> = vec![vec![]; n as usize];
        for edge in edges.iter() {
            let (a, b) = (edge[0] as usize, edge[1] as usize);
            adj[a-1].push(b as i32);
            adj[b-1].push(a as i32);
        }
        let mut dp: Vec<f64> = vec![0.0; n as usize];
        dp[0] = 1.0;
        let mut q: Vec<i32> = vec![1];
        let mut step = 0;
        while step < t {
            let mut next_q: Vec<i32> = vec![];
            for &v in q.iter() {
                let v = (v-1) as usize;
                let mut cnt = 0;
                for &w in adj[v].iter() {
                    if dp[(w-1) as usize] == 0.0 {
                        cnt += 1;
                    }
                }
                let p = if cnt == 0 { 1.0 } else { 1.0 / cnt as f64 };
                for &w in adj[v].iter() {
                    let w = (w-1) as usize;
                    if dp[w] == 0.0 {
                        dp[w] = dp[v] * p;
                        next_q.push((w+1) as i32);
                    }
                }
            }
            q = next_q;
            step += 1;
        }
        dp[(target-1) as usize]
    }
}