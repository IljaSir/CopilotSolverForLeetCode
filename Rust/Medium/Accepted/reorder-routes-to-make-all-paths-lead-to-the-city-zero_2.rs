impl Solution {
    pub fn min_reorder(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        let mut adj = vec![vec![]; n as usize];
        for c in connections {
            adj[c[0] as usize].push((c[1] as usize, 1));
            adj[c[1] as usize].push((c[0] as usize, 0));
        }
        let mut visited = vec![false; n as usize];
        let mut stack = vec![(0, 0)];
        let mut res = 0;
        while let Some((u, d)) = stack.pop() {
            if visited[u] { continue; }
            visited[u] = true;
            res += d;
            for &(v, d) in &adj[u] {
                stack.push((v, d));
            }
        }
        res
    }
}