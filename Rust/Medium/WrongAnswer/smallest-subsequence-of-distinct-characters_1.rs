impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut counts = [0; 26];
        for c in s.chars() {
            counts[(c as u8 - b'a') as usize] += 1;
        }
        let mut stack = Vec::new();
        let mut used = [false; 26];
        for c in s.chars() {
            let idx = (c as u8 - b'a') as usize;
            counts[idx] -= 1;
            if used[idx] {
                continue;
            }
            while let Some(&top) = stack.last() {
                let top_idx = (top as u8 - b'a') as usize;
                if top < c && counts[top_idx] > 0 {
                    stack.pop();
                    used[top_idx] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            used[idx] = true;
        }
        stack.into_iter().collect()
    }
}