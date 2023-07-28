impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize - 1].push(edge[1] as usize - 1);
            graph[edge[1] as usize - 1].push(edge[0] as usize - 1);
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0));
        let mut visited = vec![false; n as usize];
        let mut min_time = std::i32::MAX;
        let mut second_min_time = std::i32::MAX;
        while !queue.is_empty() {
            let (v, t) = queue.pop_front().unwrap();
            if v == (n - 1) as usize {
                if t < min_time {
                    second_min_time = min_time;
                    min_time = t;
                } else if t < second_min_time {
                    second_min_time = t;
                }
            }
            if visited[v] || t >= second_min_time {
                continue;
            }
            visited[v] = true;
            for &next_v in &graph[v] {
                let next_t = t + time + (next_v as i32 - v as i32) * change;
                queue.push_back((next_v, next_t));
            }
        }
        second_min_time
    }
}