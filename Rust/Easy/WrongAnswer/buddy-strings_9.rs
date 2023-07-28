impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        let mut diff = 0;
        let mut diff1 = -1;
        let mut diff2 = -1;
        let mut seen = [false; 26];
        for i in 0..s.len() {
            if s.as_bytes()[i] != goal.as_bytes()[i] {
                diff += 1;
                if diff1 == -1 {
                    diff1 = i as i32;
                } else {
                    diff2 = i as i32;
                }
            }
            seen[(s.as_bytes()[i] - 'a' as u8) as usize] = true;
        }
        if diff == 0 {
            for i in 0..26 {
                if seen[i] {
                    return true;
                }
            }
            return false;
        }
        if diff == 2 {
            if s.as_bytes()[diff1 as usize] == goal.as_bytes()[diff2 as usize] && s.as_bytes()[diff2 as usize] == goal.as_bytes()[diff1 as usize] {
                return true;
            }
        }
        return false;
    }
}