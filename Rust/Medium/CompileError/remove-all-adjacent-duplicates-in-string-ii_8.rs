impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut result = String::new();
        let mut stack = Vec::new();
        for c in s.chars() {
            if let Some(&last) = stack.last() {
                if last.0 == c {
                    stack.push((c, last.1 + 1));
                    if last.1 + 1 == k {
                        for _ in 0..k {
                            stack.pop();
                        }
                    }
                } else {
                    stack.push((c, 1));
                }
            } else {
                stack.push((c, 1));
            }
        }
        for (c, _) in stack {
            result.push(c);
        }
        result
    }
}