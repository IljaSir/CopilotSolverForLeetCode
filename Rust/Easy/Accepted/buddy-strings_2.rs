impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        if s.len() != goal.len() {
            return false;
        }
        let mut diff = Vec::new();
        for i in 0..s.len() {
            if s[i] != goal[i] {
                diff.push(i);
            }
        }
        if diff.len() == 0 {
            let mut m = [0; 26];
            for i in 0..s.len() {
                m[(s[i] - b'a') as usize] += 1;
            }
            for i in 0..26 {
                if m[i] >= 2 {
                    return true;
                }
            }
            return false;
        }
        if diff.len() != 2 {
            return false;
        }
        s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]]
    }
}