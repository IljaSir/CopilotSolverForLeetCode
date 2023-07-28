impl Solution {
    pub fn min_reorder(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for c in connections {
            g[c[0] as usize].push(c[1] as usize);
            g[c[1] as usize].push(c[0] as usize);
        }
        
        let mut visited = vec![false; n];
        let mut q = vec![0];
        visited[0] = true;
        let mut res = 0;
        while !q.is_empty() {
            let mut next = vec![];
            for &u in &q {
                for &v in &g[u] {
                    if !visited[v] {
                        next.push(v);
                        visited[v] = true;
                        if !g[v].contains(&u) {
                            res += 1;
                        }
                    }
                }
            }
            q = next;
        }
        res
    }
}