impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack: Vec<(char, i32)> = vec![];
        for c in s.chars() {
            if stack.is_empty() {
                stack.push((c, 1));
            } else {
                let (last_char, last_count) = stack.pop().unwrap();
                if last_char == c {
                    if last_count + 1 < k {
                        stack.push((last_char, last_count + 1));
                    }
                } else {
                    stack.push((last_char, last_count));
                    stack.push((c, 1));
                }
            }
        }
        stack.into_iter().map(|(c, n)| c.to_string().repeat(n as usize)).collect::<String>()
    }
}