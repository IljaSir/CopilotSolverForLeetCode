impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut ans = String::new();
        let mut stack = Vec::new();
        for c in s.chars() {
            if stack.is_empty() {
                stack.push(c);
                continue;
            }
            if c.is_ascii_lowercase() {
                if stack.iter().any(|&x| x.to_ascii_uppercase() == c) {
                    stack.push(c);
                } else {
                    ans = ans.max(Self::longest_nice_substring(stack.iter().collect()));
                    stack.clear();
                }
            } else {
                if stack.iter().any(|&x| x.to_ascii_lowercase() == c) {
                    stack.push(c);
                } else {
                    ans = ans.max(Self::longest_nice_substring(stack.iter().collect()));
                    stack.clear();
                }
            }
        }
        ans.max(Self::longest_nice_substring(stack.iter().collect()))
    }
}