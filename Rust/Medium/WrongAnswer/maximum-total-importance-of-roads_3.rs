impl Solution {
    pub fn maximum_importance(n: i32, roads: Vec<Vec<i32>>) -> i64 {
        
        let mut graph = vec![vec![]; n as usize];
        for road in roads {
            graph[road[0] as usize].push(road[1]);
            graph[road[1] as usize].push(road[0]);
        }
        let mut visited = vec![false; n as usize];
        let mut max = 0;
        for i in 0..n as usize {
            let mut total = 0;
            let mut stack = vec![i];
            while let Some(node) = stack.pop() {
                if visited[node] {
                    continue;
                }
                visited[node] = true;
                total += 1;
                for &next in &graph[node] {
                    stack.push(next as usize);
                }
            }
            max = max.max(total);
        }
        max as i64
    }
}