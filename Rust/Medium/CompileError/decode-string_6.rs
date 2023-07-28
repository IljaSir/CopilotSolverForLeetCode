impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let (mut result, mut stack) = (String::new(), Vec::new());
        let (mut num, mut len) = (0, s.len());
        let (mut i, mut j) = (0, 0);
        while i < len {
            if s[i..].starts_with('[') {
                stack.push((num, result.clone()));
                num = 0;
                result.clear();
                i += 1;
            } else if s[i..].starts_with(']') {
                let (n, mut r) = stack.pop().unwrap();
                result = r + &result.repeat(n);
                i += 1;
            } else if s[i..].starts_with(char::is_numeric) {
                j = i;
                while j < len && s[j..].starts_with(char::is_numeric) {
                    j += 1;
                }
                num = s[i..j].parse().unwrap();
                i = j;
            } else {
                result.push(s[i]);
                i += 1;
            }
        }
        result
    }
}