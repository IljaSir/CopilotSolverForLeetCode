impl Solution {
    pub fn buddy_strings(s: String, goal: String) -> bool {
        
        let s = s.into_bytes();
        let goal = goal.into_bytes();
        let n = s.len();
        if n != goal.len() {
            return false;
        }
        let mut diff: Vec<usize> = vec![];
        for i in 0..n {
            if s[i] != goal[i] {
                diff.push(i);
            }
        }
        if diff.len() == 0 {
            let mut cnt = vec![0; 26];
            for i in 0..n {
                cnt[(s[i] - b'a') as usize] += 1;
            }
            for i in 0..26 {
                if cnt[i] > 1 {
                    return true;
                }
            }
            return false;
        }
        if diff.len() != 2 {
            return false;
        }
        return s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]];
    }
}