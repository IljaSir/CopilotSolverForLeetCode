impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        let len = s.len();
        for i in 0..len {
            let mut j = 0;
            while j < len && s[(i + j) % len] == goal[j] {
                j += 1;
            }
            if j == len {
                return true;
            }
        }
        false
    }
}