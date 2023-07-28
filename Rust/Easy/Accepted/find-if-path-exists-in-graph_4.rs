impl Solution {
    pub fn valid_path(n: i32, edges: Vec<Vec<i32>>, source: i32, destination: i32) -> bool {
        
        let mut graph = vec![vec![]; n as usize];
        for e in edges.iter() {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut visited = vec![false; n as usize];
        let mut stack = vec![source as usize];
        while !stack.is_empty() {
            let i = stack.pop().unwrap();
            if i == destination as usize {
                return true;
            }
            if visited[i] {
                continue;
            }
            visited[i] = true;
            for j in graph[i].iter() {
                stack.push(*j);
            }
        }
        false
    }
}