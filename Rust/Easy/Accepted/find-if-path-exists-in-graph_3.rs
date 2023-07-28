impl Solution {
    pub fn valid_path(n: i32, edges: Vec<Vec<i32>>, source: i32, destination: i32) -> bool {
        
        let mut adj = vec![vec![]; n as usize];
        for e in edges {
            adj[e[0] as usize].push(e[1]);
            adj[e[1] as usize].push(e[0]);
        }
        let mut visited = vec![false; n as usize];
        let mut q = vec![source];
        visited[source as usize] = true;
        while !q.is_empty() {
            let mut nq = vec![];
            for u in q {
                if u == destination {
                    return true;
                }
                for v in adj[u as usize].iter() {
                    if !visited[*v as usize] {
                        visited[*v as usize] = true;
                        nq.push(*v);
                    }
                }
            }
            q = nq;
        }
        false
    }
}