impl Solution {
    pub fn check_if_prerequisite(num_courses: i32, prerequisites: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut adj = vec![vec![false; num_courses as usize]; num_courses as usize];
        for p in prerequisites {
            adj[p[0] as usize][p[1] as usize] = true;
        }
        for k in 0..num_courses as usize {
            for i in 0..num_courses as usize {
                for j in 0..num_courses as usize {
                    adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
                }
            }
        }
        let mut ans = vec![false; queries.len()];
        for (i, q) in queries.into_iter().enumerate() {
            ans[i] = adj[q[0] as usize][q[1] as usize];
        }
        ans
    }
}