impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut adj = vec![vec![]; n as usize];
        for i in 0..n {
            if manager[i as usize] != -1 {
                adj[manager[i as usize] as usize].push(i as usize);
            }
        }
        Solution::dfs(&adj, head_id as usize, &inform_time)
    }
    fn dfs(adj: &Vec<Vec<usize>>, u: usize, inform_time: &Vec<i32>) -> i32 {
        let mut res = 0;
        for v in &adj[u] {
            res = res.max(Solution::dfs(adj, *v, inform_time));
        }
        res + inform_time[u]
    }
}