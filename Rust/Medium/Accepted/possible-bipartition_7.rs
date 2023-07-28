impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let mut edges = vec![vec![]; n as usize];
        for dislike in dislikes {
            let (a, b) = (dislike[0] as usize - 1, dislike[1] as usize - 1);
            edges[a].push(b);
            edges[b].push(a);
        }
        let mut colors = vec![0; n as usize];
        for i in 0..n as usize {
            if colors[i] == 0 {
                let mut queue = std::collections::VecDeque::new();
                queue.push_back(i);
                colors[i] = 1;
                while !queue.is_empty() {
                    let node = queue.pop_front().unwrap();
                    for &edge in edges[node].iter() {
                        if colors[edge] == colors[node] {
                            return false;
                        }
                        if colors[edge] == 0 {
                            colors[edge] = -colors[node];
                            queue.push_back(edge);
                        }
                    }
                }
            }
        }
        true
    }
}