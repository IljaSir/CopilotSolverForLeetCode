impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1]);
        }
        let mut res = vec![vec![]; n as usize];
        for i in 0..n {
            let mut stack = vec![(i, vec![i])];
            while let Some((node, path)) = stack.pop() {
                for &next in &graph[node as usize] {
                    let mut path = path.clone();
                    path.push(next);
                    res[next as usize] = path;
                    stack.push((next, path));
                }
            }
        }
        res
    }
}