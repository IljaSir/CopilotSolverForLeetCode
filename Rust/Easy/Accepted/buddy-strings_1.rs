impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let goal: Vec<char> = goal.chars().collect();
        if s.len() != goal.len() {
            return false;
        }
        let mut diff: Vec<usize> = Vec::new();
        for i in 0..s.len() {
            if s[i] != goal[i] {
                diff.push(i);
            }
        }
        if diff.len() == 0 {
            let mut set: std::collections::HashSet<char> = std::collections::HashSet::new();
            for i in 0..s.len() {
                if set.contains(&s[i]) {
                    return true;
                }
                set.insert(s[i]);
            }
            return false;
        }
        if diff.len() != 2 {
            return false;
        }
        return s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]];
    }
}