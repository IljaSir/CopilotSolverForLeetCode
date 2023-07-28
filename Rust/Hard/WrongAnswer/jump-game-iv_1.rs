impl Solution {
    pub fn min_jumps(arr: Vec<i32>) -> i32 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for (i, &v) in arr.iter().enumerate() {
            map.entry(v).or_insert(vec![]).push(i);
        }
        let mut vis = vec![false; arr.len()];
        let mut q = vec![(0, 0)];
        vis[0] = true;
        while let Some((i, step)) = q.pop() {
            if i == arr.len() - 1 {
                return step;
            }
            if i > 0 && !vis[i - 1] {
                q.push((i - 1, step + 1));
                vis[i - 1] = true;
            }
            if i < arr.len() - 1 && !vis[i + 1] {
                q.push((i + 1, step + 1));
                vis[i + 1] = true;
            }
            if let Some(v) = map.get(&arr[i]) {
                for &j in v {
                    if !vis[j] {
                        q.push((j, step + 1));
                        vis[j] = true;
                    }
                }
                map.remove(&arr[i]);
            }
        }
        0
    }
}