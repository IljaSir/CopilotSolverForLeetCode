impl Solution {
    pub fn remove_stars(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut stack = Vec::new();
        for i in 0..s.len() {
            if s[i] == b'*' {
                if let Some(top) = stack.pop() {
                    s[top] = b' ';
                }
            } else {
                stack.push(i);
            }
        }
        String::from_utf8(s).unwrap().replace(" ", "")
    }
}