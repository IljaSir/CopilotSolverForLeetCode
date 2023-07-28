impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut seen = [false; 26];
        let mut last = [0; 26];
        let mut res = String::new();
        for (i, c) in s.chars().enumerate() {
            last[c as usize - 'a' as usize] = i;
        }
        for (i, c) in s.chars().enumerate() {
            let idx = c as usize - 'a' as usize;
            if seen[idx] {
                continue;
            }
            while let Some(&last_c) = stack.last() {
                let last_idx = last_c as usize - 'a' as usize;
                if last[last_idx] > i && c < last_c {
                    stack.pop();
                    seen[last_idx] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            seen[idx] = true;
        }
        for c in stack {
            res.push(c);
        }
        res
    }
}