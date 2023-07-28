impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let mut graph = vec![vec![]; n as usize];
        for dislike in dislikes {
            graph[(dislike[0]-1) as usize].push((dislike[1]-1) as usize);
            graph[(dislike[1]-1) as usize].push((dislike[0]-1) as usize);
        }
        let mut color = vec![-1; n as usize];
        for i in 0..n {
            if color[i as usize] == -1 {
                let mut queue = Vec::new();
                queue.push(i as usize);
                color[i as usize] = 0;
                while !queue.is_empty() {
                    let node = queue.remove(0);
                    for neighbor in &graph[node] {
                        if color[*neighbor] == -1 {
                            color[*neighbor] = 1 - color[node];
                            queue.push(*neighbor);
                        } else if color[*neighbor] == color[node] {
                            return false;
                        }
                    }
                }
            }
        }
        true
    }
}