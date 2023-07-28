impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        let mut ans = 0;
        q.push_back((0, false));
        while !q.is_empty() {
            let mut size = q.len();
            while size > 0 {
                let (pos, back) = q.pop_front().unwrap();
                if pos == x {
                    return ans;
                }
                if pos < 0 || pos > 6000 || forbidden.contains(&(pos as i32)) || visited.contains(&(pos, back)) {
                    size -= 1;
                    continue;
                }
                visited.insert((pos, back));
                q.push_back((pos + a, false));
                if !back {
                    q.push_back((pos - b, true));
                }
                size -= 1;
            }
            ans += 1;
        }
        -1
    }
}