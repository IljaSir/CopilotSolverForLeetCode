impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for dislike in dislikes {
            let (a, b) = (dislike[0] as usize - 1, dislike[1] as usize - 1);
            graph[a].push(b);
            graph[b].push(a);
        }
        let mut colors = vec![0; n];
        for i in 0..n {
            if colors[i] == 0 {
                let mut color = 1;
                let mut stack = vec![i];
                while !stack.is_empty() {
                    let node = stack.pop().unwrap();
                    if colors[node] == 0 {
                        colors[node] = color;
                    } else {
                        continue;
                    }
                    for &nei in &graph[node] {
                        stack.push(nei);
                    }
                    color = -color;
                }
            }
        }
        for i in 0..n {
            for &nei in &graph[i] {
                if colors[i] == colors[nei] {
                    return false;
                }
            }
        }
        true
    }
}