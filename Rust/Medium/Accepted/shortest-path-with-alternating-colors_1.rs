impl Solution {
    pub fn shortest_alternating_paths(n: i32, red_edges: Vec<Vec<i32>>, blue_edges: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut red = vec![vec![]; n as usize];
        let mut blue = vec![vec![]; n as usize];
        for e in red_edges {
            red[e[0] as usize].push(e[1] as usize);
        }
        for e in blue_edges {
            blue[e[0] as usize].push(e[1] as usize);
        }
        let mut ans = vec![-1; n as usize];
        ans[0] = 0;
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; n as usize]; 2];
        q.push_back((0, 0));
        q.push_back((0, 1));
        visited[0][0] = true;
        visited[1][0] = true;
        let mut step = 0;
        while !q.is_empty() {
            step += 1;
            let size = q.len();
            for _ in 0..size {
                let (i, c) = q.pop_front().unwrap();
                let next = if c == 0 { &blue[i] } else { &red[i] };
                for &j in next {
                    if ans[j] == -1 {
                        ans[j] = step;
                    }
                    if !visited[1 - c][j] {
                        q.push_back((j, 1 - c));
                        visited[1 - c][j] = true;
                    }
                }
            }
        }
        ans
    }
}