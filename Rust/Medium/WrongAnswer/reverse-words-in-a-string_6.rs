impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let mut result = String::new();
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == ' ' {
                while let Some(x) = stack.pop() {
                    result.push(x);
                }
                result.push(' ');
            } else {
                stack.push(c);
            }
        }
        while let Some(x) = stack.pop() {
            result.push(x);
        }
        result.trim().to_string()
    }
}