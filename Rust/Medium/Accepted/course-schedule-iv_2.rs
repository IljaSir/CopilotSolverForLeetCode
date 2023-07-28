impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut g = vec![vec![]; num_courses as usize];
        for p in prerequisites {
            g[p[0] as usize].push(p[1] as usize);
        }
        let mut dp = vec![vec![false; num_courses as usize]; num_courses as usize];
        for i in 0..num_courses as usize {
            let mut q = vec![];
            let mut visited = vec![false; num_courses as usize];
            q.push(i);
            visited[i] = true;
            while !q.is_empty() {
                let cur = q.pop().unwrap();
                for &next in &g[cur] {
                    if !visited[next] {
                        dp[i][next] = true;
                        q.push(next);
                        visited[next] = true;
                    }
                }
            }
        }
        let mut ans = vec![];
        for q in queries {
            ans.push(dp[q[0] as usize][q[1] as usize]);
        }
        ans
    }
}