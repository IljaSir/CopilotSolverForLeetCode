impl Solution {
    pub fn min_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut pos = std::collections::HashMap::new();
        for (i, &v) in arr.iter().enumerate() {
            pos.entry(v).or_insert(vec![]).push(i);
        }
        let mut q = std::collections::VecDeque::new();
        let mut vis = vec![false; n];
        q.push_back(0);
        vis[0] = true;
        let mut ans = 0;
        while !q.is_empty() {
            let sz = q.len();
            for _ in 0..sz {
                let u = q.pop_front().unwrap();
                if u == n - 1 {
                    return ans;
                }
                if u > 0 && !vis[u - 1] {
                    q.push_back(u - 1);
                    vis[u - 1] = true;
                }
                if u + 1 < n && !vis[u + 1] {
                    q.push_back(u + 1);
                    vis[u + 1] = true;
                }
                if let Some(&vec) = pos.get(&arr[u]) {
                    for &v in vec.iter() {
                        if !vis[v] {
                            q.push_back(v);
                            vis[v] = true;
                        }
                    }
                    pos.remove(&arr[u]);
                }
            }
            ans += 1;
        }
        ans
    }
}