impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        if s.len() != goal.len() {
            return false;
        }
        let mut diff = 0;
        let mut diff1 = 0;
        let mut diff2 = 0;
        let mut cnt = [0; 26];
        for i in 0..s.len() {
            if s[i] != goal[i] {
                diff += 1;
                if diff == 1 {
                    diff1 = i;
                } else if diff == 2 {
                    diff2 = i;
                } else {
                    return false;
                }
            }
            cnt[(s[i] - b'a') as usize] += 1;
        }
        if diff == 0 {
            cnt.iter().any(|&x| x > 1)
        } else if diff == 2 {
            s[diff1] == goal[diff2] && s[diff2] == goal[diff1]
        } else {
            false
        }
    }
}