impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize - 1].push(edge[1] as usize - 1);
            graph[edge[1] as usize - 1].push(edge[0] as usize - 1);
        }
        let mut visited = vec![false; n as usize];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, 0, 0));
        let mut ans = std::i32::MAX;
        while let Some((node, dist, color)) = queue.pop_front() {
            if node == n as usize - 1 {
                if dist < ans {
                    ans = dist;
                }
                continue;
            }
            visited[node] = true;
            let color1 = (dist / change) % 2;
            let color2 = (dist / change + 1) % 2;
            for &next in &graph[node] {
                if !visited[next] {
                    if color == color1 {
                        queue.push_back((next, dist + time, color1));
                    } else {
                        queue.push_back((next, dist + change - dist % change + time, color1));
                    }
                    if color == color2 {
                        queue.push_back((next, dist + time, color2));
                    } else {
                        queue.push_back((next, dist + change - dist % change + time, color2));
                    }
                }
            }
        }
        ans
    }
}