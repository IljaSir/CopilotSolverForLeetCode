impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        if s == goal {
            return true;
        }
        let mut ss = s.clone();
        for _ in 0..s.len() {
            ss = ss[1..].to_string() + &ss[0..1];
            if ss == goal {
                return true;
            }
        }
        false
    }
}