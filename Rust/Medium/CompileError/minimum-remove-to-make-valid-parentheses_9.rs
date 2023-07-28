impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut result = String::new();
        let mut s = s.as_bytes();
        for i in 0..s.len() {
            match s[i] {
                b'(' => stack.push(i),
                b')' => {
                    if !stack.is_empty() {
                        stack.pop();
                    } else {
                        s[i] = b' ';
                    }
                }
                _ => {}
            }
        }
        for &i in stack.iter() {
            s[i] = b' ';
        }
        for &c in s.iter() {
            if c != b' ' {
                result.push(c as char);
            }
        }
        result
    }
}