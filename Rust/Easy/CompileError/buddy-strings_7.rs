impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        if s.len() != goal.len() {
            return false;
        }
        let mut diff = vec![];
        let mut counts = vec![0; 26];
        for (c1, c2) in s.chars().zip(goal.chars()) {
            if c1 != c2 {
                diff.push((c1, c2));
                if diff.len() > 2 {
                    return false;
                }
            }
            counts[c1 as usize - 'a' as usize] += 1;
        }
        if diff.len() == 1 {
            return false;
        }
        if diff.is_empty() {
            return counts.into_iter().any(|c| c > 1);
        }
        diff[0] == diff[1].swap()
    }
}