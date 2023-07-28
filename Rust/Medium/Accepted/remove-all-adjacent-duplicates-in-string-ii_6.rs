impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if let Some((c2, mut count)) = stack.pop() {
                if c == c2 {
                    count += 1;
                    if count < k {
                        stack.push((c2, count));
                    }
                } else {
                    stack.push((c2, count));
                    stack.push((c, 1));
                }
            } else {
                stack.push((c, 1));
            }
        }
        stack.iter().map(|(c, n)| c.to_string().repeat(*n as usize)).collect()
    }
}