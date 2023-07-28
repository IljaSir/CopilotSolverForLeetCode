impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() { return false; }
        if s == goal { return true; }
        let mut s = s;
        let mut goal = goal;
        let mut i = 0;
        while i < s.len() {
            s.push(s.remove(0));
            if s == goal { return true; }
            i += 1;
        }
        false
    }
}