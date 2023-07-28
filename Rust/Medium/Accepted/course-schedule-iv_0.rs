impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let n = num_courses as usize;
        let mut g = vec![vec![]; n];
        for p in prerequisites {
            g[p[0] as usize].push(p[1] as usize);
        }
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            let mut q = vec![];
            let mut vis = vec![false; n];
            q.push(i);
            vis[i] = true;
            while !q.is_empty() {
                let u = q.remove(0);
                for &v in &g[u] {
                    if !vis[v] {
                        vis[v] = true;
                        q.push(v);
                        dp[i][v] = true;
                    }
                }
            }
        }
        let mut res = vec![];
        for q in queries {
            res.push(dp[q[0] as usize][q[1] as usize]);
        }
        res
    }
}