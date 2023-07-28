impl Solution {
    pub fn min_reorder(n: i32, connections: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for connection in connections {
            let (a, b) = (connection[0] as usize, connection[1] as usize);
            graph[a].push((b, true));
            graph[b].push((a, false));
        }
        let mut visited = vec![false; n];
        let mut count = 0;
        let mut stack = vec![0];
        while let Some(node) = stack.pop() {
            if visited[node] {
                continue;
            }
            visited[node] = true;
            for (neibor, forward) in &graph[node] {
                if !visited[*neibor] {
                    if *forward {
                        count += 1;
                    }
                    stack.push(*neibor);
                }
            }
        }
        count
    }
}