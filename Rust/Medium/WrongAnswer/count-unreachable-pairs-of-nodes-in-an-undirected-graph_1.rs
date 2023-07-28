impl Solution {
    pub fn count_pairs(n: i32, edges: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for e in edges {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut visited = vec![false; n];
        let mut count = 0;
        for i in 0..n {
            if visited[i] { continue; }
            let mut q = std::collections::VecDeque::new();
            q.push_back(i);
            visited[i] = true;
            while let Some(u) = q.pop_front() {
                for &v in &graph[u] {
                    if !visited[v] {
                        visited[v] = true;
                        q.push_back(v);
                    }
                }
            }
            count += 1;
        }
        let mut res = 0;
        for i in 0..n {
            res += (n - i - 1 - graph[i].len()) as i64;
        }
        res - (count - 1) as i64
    }
}