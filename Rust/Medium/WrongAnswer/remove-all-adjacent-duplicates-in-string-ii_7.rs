impl Solution {
    pub fn remove_duplicates(s: String, k: i32) -> String {
        
        let mut stack = vec![];
        for c in s.chars() {
            if stack.is_empty() {
                stack.push((c, 1));
            } else {
                let (last_c, last_count) = stack.last().unwrap();
                if last_c == &c {
                    if last_count + 1 == k {
                        stack.pop();
                    } else {
                        stack.push((c, last_count + 1));
                    }
                } else {
                    stack.push((c, 1));
                }
            }
        }
        stack.iter().map(|(c, _)| *c).collect()
    }
}