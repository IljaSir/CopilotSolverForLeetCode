impl Solution {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        
        let mut graph = vec![vec![]; n as usize];
        for road in roads {
            graph[road[0] as usize].push(road[1] as usize);
            graph[road[1] as usize].push(road[0] as usize);
        }
        let mut visited = vec![false; n as usize];
        let mut max = 0;
        for i in 0..n {
            let mut sum = 0;
            let mut stack = vec![i as usize];
            while !stack.is_empty() {
                let u = stack.pop().unwrap();
                if !visited[u] {
                    visited[u] = true;
                    sum += 1;
                    for v in graph[u].iter() {
                        stack.push(*v);
                    }
                }
            }
            max = max.max(sum);
        }
        max as i64
    }
}