impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut stack: Vec<char> = vec![];
        for c in s.chars() {
            if let Some(&x) = stack.last() {
                if x == c {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        stack.len() as i32
    }
}