impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut last = vec![0; 26];
        let mut seen = vec![false; 26];
        let mut stack = vec![];
        let s = s.as_bytes();
        for i in 0..s.len() {
            last[(s[i] - b'a') as usize] = i;
        }
        for i in 0..s.len() {
            let c = (s[i] - b'a') as usize;
            if seen[c] {
                continue;
            }
            while let Some(&ch) = stack.last() {
                if ch > c && last[ch] > i {
                    stack.pop();
                    seen[ch] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            seen[c] = true;
        }
        stack
            .into_iter()
            .map(|c| (b'a' + c as u8) as char)
            .collect()
    }
}