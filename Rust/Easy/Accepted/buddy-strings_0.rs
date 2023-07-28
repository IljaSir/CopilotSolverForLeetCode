impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        if s == goal {
            let mut set = std::collections::HashSet::new();
            for c in s.chars() {
                if set.contains(&c) {
                    return true;
                }
                set.insert(c);
            }
            return false;
        }
        let mut diff = Vec::new();
        for (a, b) in s.chars().zip(goal.chars()) {
            if a != b {
                diff.push((a, b));
            }
            if diff.len() > 2 {
                return false;
            }
        }
        if diff.len() == 2 {
            return diff[0].0 == diff[1].1 && diff[0].1 == diff[1].0;
        }
        false
    }
}