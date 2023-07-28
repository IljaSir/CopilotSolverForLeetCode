impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        let n = s.len();
        if n != goal.len() {
            return false;
        }
        let mut diff = Vec::new();
        for i in 0..n {
            if s[i] != goal[i] {
                diff.push(i);
            }
        }
        if diff.len() == 2 {
            s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]]
        } else if diff.is_empty() {
            let mut seen = [false; 26];
            for &c in s {
                let i = (c - b'a') as usize;
                if seen[i] {
                    return true;
                }
                seen[i] = true;
            }
            false
        } else {
            false
        }
    }
}