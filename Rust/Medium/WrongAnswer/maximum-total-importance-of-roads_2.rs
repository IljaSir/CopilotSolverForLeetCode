impl Solution {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for road in roads {
            graph[road[0] as usize].push(road[1] as usize);
            graph[road[1] as usize].push(road[0] as usize);
        }
        let mut visited = vec![false; n];
        let mut max_importance = 0;
        for i in 0..n {
            if visited[i] {
                continue;
            }
            let mut importance = 0;
            let mut stack = vec![i];
            visited[i] = true;
            while let Some(node) = stack.pop() {
                importance += 1;
                for &next in &graph[node] {
                    if visited[next] {
                        continue;
                    }
                    stack.push(next);
                    visited[next] = true;
                }
            }
            max_importance = max_importance.max(importance * (importance - 1) as usize);
        }
        max_importance as i64
    }
}