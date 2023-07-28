impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut visited = vec![false; 6000];
        for f in forbidden {
            visited[f as usize] = true;
        }
        let a = a as usize;
        let b = b as usize;
        let x = x as usize;
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, false));
        visited[0] = true;
        let mut d = 0;
        while !q.is_empty() {
            let n = q.len();
            for _ in 0..n {
                let (pos, back) = q.pop_front().unwrap();
                if pos == x {
                    return d;
                }
                let pos = pos as usize;
                if pos + a < visited.len() && !visited[pos + a] {
                    visited[pos + a] = true;
                    q.push_back((pos + a, false));
                }
                if !back && pos >= b && !visited[pos - b] {
                    visited[pos - b] = true;
                    q.push_back((pos - b, true));
                }
            }
            d += 1;
        }
        -1
    }
}