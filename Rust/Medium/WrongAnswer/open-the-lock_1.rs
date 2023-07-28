impl Solution {
    pub fn open_lock(deadends: Vec<String>, target: String) -> i32 {
        
        use std::collections::HashSet;
        let mut deadends = deadends.into_iter().map(|s| s.parse::<i32>().unwrap()).collect::<HashSet<i32>>();
        let target = target.parse::<i32>().unwrap();
        if deadends.contains(&0) {
            return -1;
        }
        let mut visited = HashSet::new();
        let mut queue = vec![(0, 0)];
        while !queue.is_empty() {
            let (mut node, mut depth) = queue.remove(0);
            if node == target {
                return depth;
            }
            let mut next = vec![];
            for i in 0..4 {
                let mut x = node;
                let mut y = node;
                let mut z = node;
                let mut w = node;
                x += 10i32.pow(i);
                y -= 10i32.pow(i);
                z += 10i32.pow(3-i);
                w -= 10i32.pow(3-i);
                if x > 9999 {
                    x -= 10000;
                }
                if y < 0 {
                    y += 10000;
                }
                if z > 9999 {
                    z -= 10000;
                }
                if w < 0 {
                    w += 10000;
                }
                if !deadends.contains(&x) && !visited.contains(&x) {
                    next.push(x);
                    visited.insert(x);
                }
                if !deadends.contains(&y) && !visited.contains(&y) {
                    next.push(y);
                    visited.insert(y);
                }
                if !deadends.contains(&z) && !visited.contains(&z) {
                    next.push(z);
                    visited.insert(z);
                }
                if !deadends.contains(&w) && !visited.contains(&w) {
                    next.push(w);
                    visited.insert(w);
                }
            }
            for n in next {
                queue.push((n, depth + 1));
            }
        }
        -1
    }
}