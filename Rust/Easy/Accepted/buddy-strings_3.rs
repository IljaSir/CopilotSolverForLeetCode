impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s = s.as_bytes();
        let goal = goal.as_bytes();
        if s.len() != goal.len() {
            return false;
        }
        if s == goal {
            let mut count = vec![0; 26];
            for i in 0..s.len() {
                count[(s[i] - b'a') as usize] += 1;
            }
            return count.iter().any(|&x| x > 1);
        }
        let mut diff = vec![];
        for i in 0..s.len() {
            if s[i] != goal[i] {
                diff.push(i);
            }
        }
        if diff.len() != 2 {
            return false;
        }
        s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]]
    }
}