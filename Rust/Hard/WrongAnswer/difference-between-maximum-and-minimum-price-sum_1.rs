impl Solution {
    pub fn max_output(n: i32, edges: Vec<Vec<i32>>, price: Vec<i32>) -> i64 {
        
        let mut adj = vec![vec![]; n as usize];
        for edge in edges {
            adj[edge[0] as usize].push(edge[1] as usize);
            adj[edge[1] as usize].push(edge[0] as usize);
        }
        let mut ans = 0;
        let mut dp = vec![0; n as usize];
        let mut sum = vec![0; n as usize];
        let mut queue = vec![0];
        let mut visited = vec![false; n as usize];
        visited[0] = true;
        while !queue.is_empty() {
            let mut next = vec![];
            for node in queue {
                for &neigh in &adj[node] {
                    if !visited[neigh] {
                        visited[neigh] = true;
                        next.push(neigh);
                        dp[neigh] = dp[node] + price[neigh];
                        sum[neigh] = sum[node] + price[neigh];
                    }
                }
            }
            queue = next;
        }
        let mut max = 0;
        let mut min = sum[n as usize - 1];
        for i in (1..n as usize).rev() {
            max = max.max(sum[i] - dp[i]);
            min = min.min(sum[i] - dp[i]);
        }
        ans = max - min;
        ans as i64
    }
}