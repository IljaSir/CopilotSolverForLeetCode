impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        if s.len() == 0 {
            return true;
        }
        let mut s = s;
        let goal = goal;
        let mut i = 0;
        while i < s.len() {
            if s == goal {
                return true;
            }
            let c = s.remove(0);
            s.push(c);
            i += 1;
        }
        false
    }
}