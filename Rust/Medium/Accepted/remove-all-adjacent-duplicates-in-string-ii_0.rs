impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if let Some((last, count)) = stack.last_mut() {
                if *last == c {
                    *count += 1;
                    if *count == k {
                        stack.pop();
                    }
                } else {
                    stack.push((c, 1));
                }
            } else {
                stack.push((c, 1));
            }
        }
        stack.into_iter().map(|(c, count)| c.to_string().repeat(count as usize)).collect()
    }
}