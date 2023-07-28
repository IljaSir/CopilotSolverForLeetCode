impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            if let Some(&last) = stack.last() {
                if last == c {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        stack.into_iter().collect()
    }
}