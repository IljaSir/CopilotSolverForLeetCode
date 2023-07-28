impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut seen = std::collections::HashSet::new();
        q.push_back((0, false));
        let mut step = 0;
        while !q.is_empty() {
            let mut size = q.len();
            while size > 0 {
                let (pos, back) = q.pop_front().unwrap();
                if pos == x as i64 {
                    return step;
                }
                if pos < 0 || pos > 6000 || forbidden.contains(&(pos as i32)) || seen.contains(&(pos, back)) {
                    size -= 1;
                    continue;
                }
                seen.insert((pos, back));
                q.push_back((pos + a as i64, false));
                if !back {
                    q.push_back((pos - b as i64, true));
                }
                size -= 1;
            }
            step += 1;
        }
        -1
    }
}