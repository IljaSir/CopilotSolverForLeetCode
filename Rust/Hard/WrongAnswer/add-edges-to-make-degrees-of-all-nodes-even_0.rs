impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for e in edges {
            graph[e[0] as usize - 1].push(e[1] as usize - 1);
            graph[e[1] as usize - 1].push(e[0] as usize - 1);
        }
        let mut degree = vec![0; n];
        for i in 0..n {
            degree[i] = graph[i].len();
        }
        let mut queue = std::collections::VecDeque::new();
        for i in 0..n {
            if degree[i] % 2 == 1 {
                queue.push_back(i);
            }
        }
        while !queue.is_empty() {
            let cur = queue.pop_front().unwrap();
            if degree[cur] % 2 == 1 {
                for &next in &graph[cur] {
                    degree[next] -= 1;
                    degree[cur] -= 1;
                    if degree[next] % 2 == 1 {
                        queue.push_back(next);
                    }
                    break;
                }
            }
        }
        for i in 0..n {
            if degree[i] % 2 == 1 {
                return false;
            }
        }
        true
    }
}