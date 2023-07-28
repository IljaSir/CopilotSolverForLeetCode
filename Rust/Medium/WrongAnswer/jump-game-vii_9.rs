impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![false; s.len()];
        q.push_back(0);
        visited[0] = true;
        let mut i = 0;
        let mut j = 0;
        while let Some(idx) = q.pop_front() {
            i = (idx + min_jump) as usize;
            j = (idx + max_jump) as usize;
            if j >= s.len() - 1 {
                return true;
            }
            while i <= j && i < s.len() {
                if !visited[i] && s.as_bytes()[i] == b'0' {
                    q.push_back(i as i32);
                    visited[i] = true;
                }
                i += 1;
            }
        }
        false
    }
}