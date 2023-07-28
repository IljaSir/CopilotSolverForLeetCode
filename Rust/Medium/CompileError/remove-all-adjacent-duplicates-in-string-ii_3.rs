impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack: Vec<(char, i32)> = vec![];
        for c in s.chars() {
            if let Some((_, count)) = stack.last_mut() {
                if *count == k - 1 && *c == stack.last().unwrap().0 {
                    stack.pop();
                    continue;
                }
                if *c == stack.last().unwrap().0 {
                    *count += 1;
                    continue;
                }
            }
            stack.push((c, 1));
        }
        stack
            .into_iter()
            .map(|(c, count)| c.to_string().repeat(count as usize))
            .collect()
    }
}