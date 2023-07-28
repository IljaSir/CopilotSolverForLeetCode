impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        

        let mut stack = Vec::new();
        let mut visited = vec![false; 26];
        let mut last_occurrence = vec![0; 26];
        let s = s.as_bytes();
        for i in 0..s.len() {
            last_occurrence[(s[i] - b'a') as usize] = i;
        }
        for i in 0..s.len() {
            let c = (s[i] - b'a') as usize;
            if visited[c] {
                continue;
            }
            while let Some(&top) = stack.last() {
                if top > c && i < last_occurrence[top] {
                    visited[top] = false;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(c);
            visited[c] = true;
        }
        let mut res = Vec::new();
        for &c in &stack {
            res.push((c as u8 + b'a') as char);
        }
        res.iter().collect()
    }
}