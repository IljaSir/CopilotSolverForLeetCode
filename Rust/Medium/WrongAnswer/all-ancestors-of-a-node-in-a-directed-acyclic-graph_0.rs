impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[1] as usize].push(edge[0]);
        }
        let mut result = vec![vec![]; n as usize];
        for i in 0..n {
            let mut queue = vec![];
            queue.push(i);
            while !queue.is_empty() {
                let node = queue.pop().unwrap();
                for neighbor in &graph[node as usize] {
                    if !result[i as usize].contains(neighbor) {
                        result[i as usize].push(*neighbor);
                        queue.push(*neighbor);
                    }
                }
            }
        }
        result
    }
}