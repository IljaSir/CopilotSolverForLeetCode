impl Solution {
    pub fn find_min_height_trees(n: i32, edges: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut ans = vec![];
        let mut adj = vec![vec![]; n as usize];
        let mut degree = vec![0; n as usize];
        for edge in edges {
            adj[edge[0] as usize].push(edge[1] as usize);
            adj[edge[1] as usize].push(edge[0] as usize);
            degree[edge[0] as usize] += 1;
            degree[edge[1] as usize] += 1;
        }
        let mut q = std::collections::VecDeque::new();
        for i in 0..n {
            if degree[i as usize] == 1 {
                q.push_back(i);
            }
        }
        while n - q.len() as i32 > 2 {
            let size = q.len();
            for _ in 0..size {
                if let Some(node) = q.pop_front() {
                    for i in &adj[node as usize] {
                        degree[*i] -= 1;
                        if degree[*i] == 1 {
                            q.push_back(*i as i32);
                        }
                    }
                }
            }
        }
        while let Some(node) = q.pop_front() {
            ans.push(node);
        }
        ans
    }
}