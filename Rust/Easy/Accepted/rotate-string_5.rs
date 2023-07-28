impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        
        if s == goal {
            return true;
        }
        
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        for i in 0..s.len() {
            if s[i] == goal[0] {
                let mut j = 0;
                while i + j < s.len() && s[i + j] == goal[j] {
                    j += 1;
                }
                if j == s.len() {
                    return true;
                }
                let mut k = 0;
                while k < i && s[k] == goal[j] {
                    k += 1;
                    j += 1;
                }
                if k == i && j == s.len() {
                    return true;
                }
            }
        }
        false
    }
}