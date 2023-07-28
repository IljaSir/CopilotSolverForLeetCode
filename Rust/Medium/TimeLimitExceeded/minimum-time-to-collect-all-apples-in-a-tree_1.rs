impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        
        let mut adj = vec![vec![]; n as usize];
        for e in edges {
            adj[e[0] as usize].push(e[1]);
            adj[e[1] as usize].push(e[0]);
        }
        let mut visited = vec![false; n as usize];
        visited[0] = true;
        let mut ans = 0;
        for i in 1..n as usize {
            if has_apple[i] && !visited[i] {
                ans += 2;
                let mut cur = i;
                while cur != 0 {
                    visited[cur] = true;
                    for next in adj[cur].iter() {
                        if !visited[*next as usize] {
                            cur = *next as usize;
                            break;
                        }
                    }
                }
            }
        }
        ans
    }
}