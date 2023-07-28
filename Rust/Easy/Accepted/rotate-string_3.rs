impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        if s == goal {
            return true;
        }
        let mut s = s.chars().collect::<Vec<char>>();
        for _ in 0..s.len() {
            s.rotate_left(1);
            if s.iter().collect::<String>() == goal {
                return true;
            }
        }
        false
    }
}