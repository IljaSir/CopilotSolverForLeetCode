impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        let mut indegree = vec![0; n as usize];
        for e in edges {
            let u = e[0] as usize;
            let v = e[1] as usize;
            graph[u].push(v);
            indegree[v] += 1;
        }
        let mut q = std::collections::VecDeque::new();
        for i in 0..n as usize {
            if indegree[i] == 0 {
                q.push_back(i);
            }
        }
        let mut res = vec![vec![]; n as usize];
        while !q.is_empty() {
            let u = q.pop_front().unwrap();
            for &v in graph[u].iter() {
                indegree[v] -= 1;
                if indegree[v] == 0 {
                    q.push_back(v);
                }
                res[v].push(u as i32);
                res[v].append(&mut res[u].clone());
            }
        }
        res
    }
}