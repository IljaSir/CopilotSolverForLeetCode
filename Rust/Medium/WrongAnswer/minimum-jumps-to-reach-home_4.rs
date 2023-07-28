impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut forbidden = forbidden;
        forbidden.sort_unstable();
        let mut q = std::collections::VecDeque::new();
        let mut seen = std::collections::HashSet::new();
        q.push_back((0, 0));
        seen.insert((0, 0));
        while !q.is_empty() {
            let (p, d) = q.pop_front().unwrap();
            if p == x {
                return d;
            }
            if p + a <= 6000 && !forbidden.contains(&(p + a)) && !seen.contains(&(p + a, 0)) {
                seen.insert((p + a, 0));
                q.push_back((p + a, d + 1));
            }
            if p - b >= 0 && !forbidden.contains(&(p - b)) && d > 0 && !seen.contains(&(p - b, 1)) {
                seen.insert((p - b, 1));
                q.push_back((p - b, d + 1));
            }
        }
        -1
    }
}