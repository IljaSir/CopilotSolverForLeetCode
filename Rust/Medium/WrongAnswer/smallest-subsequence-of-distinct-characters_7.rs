impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut last = vec![0; 26];
        let mut visited = vec![false; 26];
        let mut stack = Vec::new();
        let mut ans = String::new();
        for (i, c) in s.bytes().enumerate() {
            last[(c - b'a') as usize] = i;
        }
        for (i, c) in s.bytes().enumerate() {
            let idx = (c - b'a') as usize;
            if visited[idx] {
                continue;
            }
            while let Some(&top) = stack.last() {
                let top_idx = (top - b'a') as usize;
                if top < c && i < last[top_idx] {
                    stack.pop();
                    visited[top_idx] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            visited[idx] = true;
        }
        while let Some(c) = stack.pop() {
            ans.push(c as char);
        }
        ans.chars().rev().collect()
    }
}