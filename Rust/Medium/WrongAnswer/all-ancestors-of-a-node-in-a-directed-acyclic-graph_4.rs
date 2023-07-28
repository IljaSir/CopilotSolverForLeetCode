impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut adj = vec![vec![]; n as usize];
        for edge in edges {
            adj[edge[0] as usize].push(edge[1]);
        }
        let mut ans = vec![vec![]; n as usize];
        for i in 0..n {
            Self::dfs(i, &adj, &mut ans);
        }
        ans
    }
    fn dfs(i: i32, adj: &Vec<Vec<i32>>, ans: &mut Vec<Vec<i32>>) {
        for &j in &adj[i as usize] {
            ans[j as usize].push(i);
            Self::dfs(j, adj, ans);
        }
    }
}