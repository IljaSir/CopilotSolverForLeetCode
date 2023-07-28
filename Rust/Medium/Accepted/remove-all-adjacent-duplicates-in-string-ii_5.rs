impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack: Vec<(char, i32)> = Vec::new();
        for c in s.chars() {
            if stack.len() > 0 && stack.last().unwrap().0 == c {
                let mut p = stack.last_mut().unwrap();
                p.1 += 1;
                if p.1 == k {
                    stack.pop();
                }
            } else {
                stack.push((c, 1));
            }
        }
        stack.iter().map(|t| t.0.to_string().repeat(t.1 as usize)).collect()
    }
}