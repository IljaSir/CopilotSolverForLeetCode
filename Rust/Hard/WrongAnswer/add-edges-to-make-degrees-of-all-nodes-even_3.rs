impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut g = vec![vec![]; n + 1];
        for e in edges.iter() {
            g[e[0] as usize].push(e[1] as usize);
            g[e[1] as usize].push(e[0] as usize);
        }
        let mut odd = 0;
        for i in 1..=n {
            if g[i].len() % 2 == 1 {
                odd += 1;
            }
        }
        if odd % 2 == 1 {
            return false;
        }
        if odd == 0 {
            return true;
        }
        let mut vis = vec![false; n + 1];
        let mut q = vec![];
        for i in 1..=n {
            if g[i].len() % 2 == 1 {
                q.push(i);
                vis[i] = true;
                break;
            }
        }
        while !q.is_empty() {
            let u = q.pop().unwrap();
            for &v in g[u].iter() {
                if vis[v] {
                    continue;
                }
                vis[v] = true;
                q.push(v);
            }
        }
        for i in 1..=n {
            if !vis[i] {
                continue;
            }
            let mut q = vec![i];
            let mut vis = vec![false; n + 1];
            vis[i] = true;
            while !q.is_empty() {
                let u = q.pop().unwrap();
                for &v in g[u].iter() {
                    if vis[v] {
                        continue;
                    }
                    vis[v] = true;
                    q.push(v);
                }
            }
            for j in 1..=n {
                if vis[j] {
                    continue;
                }
                if g[j].len() % 2 == 1 {
                    return false;
                }
            }
            return true;
        }
        false
    }
}