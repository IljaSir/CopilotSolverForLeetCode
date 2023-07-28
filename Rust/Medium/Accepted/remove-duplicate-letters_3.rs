impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        

        let mut stack = vec![];
        let mut last_index = [0; 26];
        let mut visited = [false; 26];
        let mut s = s.as_bytes().iter().map(|&c| (c - b'a') as usize).collect::<Vec<_>>();
        for (i, &c) in s.iter().enumerate() {
            last_index[c] = i;
        }
        for (i, &c) in s.iter().enumerate() {
            if visited[c] {
                continue;
            }
            while !stack.is_empty() && stack[stack.len() - 1] > c && i < last_index[stack[stack.len() - 1]] {
                let top = stack.pop().unwrap();
                visited[top] = false;
            }
            stack.push(c);
            visited[c] = true;
        }
        stack.iter().map(|&c| (c as u8 + b'a') as char).collect()
    }
}