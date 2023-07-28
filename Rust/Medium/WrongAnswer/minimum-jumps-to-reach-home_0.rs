impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        for i in &forbidden {
            visited.insert(*i);
        }
        q.push_back((0, true));
        let mut ans = 0;
        while !q.is_empty() {
            let mut next = std::collections::VecDeque::new();
            while let Some((pos, forward)) = q.pop_front() {
                if pos == x {
                    return ans;
                }
                if !visited.contains(&pos) {
                    visited.insert(pos);
                    if pos + a <= 6000 {
                        next.push_back((pos + a, true));
                    }
                    if pos - b >= 0 && !forward {
                        next.push_back((pos - b, false));
                    }
                }
            }
            q = next;
            ans += 1;
        }
        -1
    }
}