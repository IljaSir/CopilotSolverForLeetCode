impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut last = vec![-1; 26];
        for (i, c) in s.chars().enumerate() {
            last[(c as u8 - b'a') as usize] = i as _;
        }
        let mut seen = vec![false; 26];
        let mut stack = vec![];
        for (i, c) in s.chars().enumerate() {
            let ci = (c as u8 - b'a') as usize;
            if seen[ci] {
                continue;
            }
            while let Some(&top) = stack.last() {
                let topi = (top as u8 - b'a') as usize;
                if topi < ci || last[topi] < i {
                    break;
                }
                seen[topi] = false;
                stack.pop();
            }
            stack.push(c);
            seen[ci] = true;
        }
        stack.into_iter().collect()
    }
}