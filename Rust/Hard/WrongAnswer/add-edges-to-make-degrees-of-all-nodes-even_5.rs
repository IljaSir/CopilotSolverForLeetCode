impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut degree = vec![0; n];
        let mut graph = vec![vec![]; n];
        for edge in &edges {
            let (x, y) = (edge[0] as usize - 1, edge[1] as usize - 1);
            graph[x].push(y);
            graph[y].push(x);
            degree[x] += 1;
            degree[y] += 1;
        }
        let mut queue = std::collections::VecDeque::new();
        for i in 0..n {
            if degree[i] % 2 == 1 {
                queue.push_back(i);
            }
        }
        while !queue.is_empty() {
            let x = queue.pop_front().unwrap();
            let mut found = false;
            for &y in &graph[x] {
                if degree[y] % 2 == 1 {
                    degree[x] -= 1;
                    degree[y] -= 1;
                    found = true;
                    break;
                }
            }
            if !found {
                return false;
            }
        }
        true
    }
}