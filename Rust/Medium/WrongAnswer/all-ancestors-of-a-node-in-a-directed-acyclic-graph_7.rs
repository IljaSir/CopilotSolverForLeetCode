impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        let mut res = vec![vec![]; n as usize];
        for v in edges {
            graph[v[0] as usize].push(v[1] as usize);
        }
        for i in 0..n as usize {
            let mut visited = vec![false; n as usize];
            let mut stack = vec![i];
            while !stack.is_empty() {
                let u = stack.pop().unwrap();
                if visited[u] {
                    continue;
                }
                visited[u] = true;
                for &v in &graph[u] {
                    stack.push(v);
                    res[v].push(u as i32);
                }
            }
        }
        res
    }
}