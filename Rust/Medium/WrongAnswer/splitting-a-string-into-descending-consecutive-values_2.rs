impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let s = s.as_bytes();
        let mut stack = Vec::new();
        stack.push((0, 0));
        while let Some((i, last)) = stack.pop() {
            if i == s.len() {
                return true;
            }
            for j in i + 1..=s.len() {
                if let Ok(num) = std::str::from_utf8(&s[i..j]).unwrap().parse::<i32>() {
                    if last == 0 || last == num + 1 {
                        stack.push((j, num));
                    }
                }
            }
        }
        false
    }
}