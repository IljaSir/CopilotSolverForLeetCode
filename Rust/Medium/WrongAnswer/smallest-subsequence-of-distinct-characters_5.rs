impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut stack = Vec::new();
        let mut seen = [false; 26];
        let mut last = [0; 26];
        for (i, &c) in s.iter().enumerate() {
            last[(c - b'a') as usize] = i;
        }
        for (i, &c) in s.iter().enumerate() {
            let idx = (c - b'a') as usize;
            if seen[idx] {
                continue;
            }
            while let Some(&top) = stack.last() {
                let top_idx = (top - b'a') as usize;
                if top < c && last[top_idx] > i {
                    stack.pop();
                    seen[top_idx] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            seen[idx] = true;
        }
        unsafe { String::from_utf8_unchecked(stack) }
    }
}