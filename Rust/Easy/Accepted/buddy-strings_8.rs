impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        let mut diff = 0;
        let mut diff1 = 0;
        let mut diff2 = 0;
        let mut s1 = 0;
        let mut s2 = 0;
        let mut g1 = 0;
        let mut g2 = 0;
        for i in 0..s.len() {
            if s.as_bytes()[i] != goal.as_bytes()[i] {
                diff += 1;
                if diff == 1 {
                    diff1 = i;
                } else if diff == 2 {
                    diff2 = i;
                    s1 = s.as_bytes()[diff1];
                    s2 = s.as_bytes()[diff2];
                    g1 = goal.as_bytes()[diff1];
                    g2 = goal.as_bytes()[diff2];
                } else {
                    return false;
                }
            }
        }
        if diff == 0 {
            let mut map = vec![0; 26];
            for i in 0..s.len() {
                map[(s.as_bytes()[i] - 'a' as u8) as usize] += 1;
            }
            for i in 0..26 {
                if map[i] >= 2 {
                    return true;
                }
            }
            return false;
        } else if diff == 2 {
            return s1 == g2 && s2 == g1;
        } else {
            return false;
        }
    }
}