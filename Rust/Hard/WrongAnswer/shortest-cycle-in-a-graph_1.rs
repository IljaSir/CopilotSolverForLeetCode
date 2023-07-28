impl Solution {
    pub fn find_shortest_cycle(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        
        let mut g = vec![vec![]; n as usize];
        for e in edges {
            g[e[0] as usize].push(e[1] as usize);
            g[e[1] as usize].push(e[0] as usize);
        }
        let mut ans = n + 1;
        for i in 0..n {
            let mut q = std::collections::VecDeque::new();
            let mut v = vec![false; n as usize];
            let mut d = vec![0; n as usize];
            q.push_back(i as usize);
            v[i as usize] = true;
            while !q.is_empty() {
                let u = q.pop_front().unwrap();
                for &w in &g[u] {
                    if v[w] {
                        if w == i as usize {
                            ans = ans.min(d[u] + 1);
                        }
                    } else {
                        d[w] = d[u] + 1;
                        v[w] = true;
                        q.push_back(w);
                    }
                }
            }
        }
        if ans == n + 1 {
            -1
        } else {
            ans as i32
        }
    }
}