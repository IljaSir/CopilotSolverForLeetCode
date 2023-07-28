impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut res = vec![];
        let bytes = s.into_bytes();
        let mut stack = vec![];
        Self::backtrack(&bytes, 0, &mut stack, &mut res);
        res
    }
    fn backtrack(s: &[u8], start: usize, stack: &mut Vec<String>, res: &mut Vec<String>) {
        if stack.len() == 4 {
            if start == s.len() {
                res.push(stack.join("."));
            }
            return;
        }
        for i in start..start+3 {
            if i >= s.len() {
                break;
            }
            if i > start && s[start] == b'0' {
                break;
            }
            let ip = unsafe { std::str::from_utf8_unchecked(&s[start..=i]) };
            let ip = ip.parse::<i32>().unwrap();
            if ip > 255 {
                break;
            }
            stack.push(ip.to_string());
            Self::backtrack(s, i+1, stack, res);
            stack.pop();
        }
    }
}