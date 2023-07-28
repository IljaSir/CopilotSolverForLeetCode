impl Solution {
    pub fn remove_duplicates(s: String) -> String {
        
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            if stack.len() == 0 {
                stack.push(c);
            } else {
                if stack[stack.len() - 1] == c {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        stack.iter().collect()
    }
}