impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        let mut s = s.chars().collect::<Vec<char>>();
        for _ in 0..s.len() {
            let tmp = s.remove(0);
            s.push(tmp);
            if s == goal.chars().collect::<Vec<char>>() {
                return true;
            }
        }
        false
    }
}