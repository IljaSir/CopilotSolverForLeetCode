impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1] as usize);
        }
        let mut ans = vec![vec![]; n as usize];
        for i in 0..n {
            let mut stack = vec![i as usize];
            while let Some(node) = stack.pop() {
                for &child in &graph[node] {
                    if !ans[child].contains(&i) {
                        ans[child].push(i);
                        stack.push(child);
                    }
                }
            }
        }
        ans
    }
}