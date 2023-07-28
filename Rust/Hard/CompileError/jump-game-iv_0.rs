impl Solution {
    pub fn min_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut pos: HashMap<i32, Vec<usize>> = HashMap::new();
        for (i, &a) in arr.iter().enumerate() {
            pos.entry(a).or_default().push(i);
        }
        let mut q = VecDeque::new();
        let mut vis = vec![false; n];
        q.push_back((0, 0));
        vis[0] = true;
        while let Some((i, step)) = q.pop_front() {
            if i == n - 1 {
                return step;
            }
            for &j in &[i + 1, i + n as usize, i + n as usize].iter().filter(|&&j| j < n) {
                if !vis[j] {
                    vis[j] = true;
                    q.push_back((j, step + 1));
                }
            }
            if let Some(v) = pos.get_mut(&arr[i]) {
                for &j in v.drain(..) {
                    if !vis[j] {
                        vis[j] = true;
                        q.push_back((j, step + 1));
                    }
                }
            }
        }
        0
    }
}