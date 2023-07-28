impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        let s = s.as_bytes();
        Self::backtrack(s, 0, &mut path, &mut res);
        res
    }
    
    fn backtrack(s: &[u8], start: usize, path: &mut Vec<String>, res: &mut Vec<String>) {
        if path.len() == 4 {
            if start == s.len() {
                res.push(path.join("."));
            }
            return;
        }
        
        for i in 1..=3 {
            if start + i > s.len() {
                break;
            }
            if s[start] == b'0' && i > 1 {
                break;
            }
            let num = std::str::from_utf8(&s[start..start+i]).unwrap().parse::<i32>().unwrap();
            if num > 255 {
                break;
            }
            path.push(num.to_string());
            Self::backtrack(s, start + i, path, res);
            path.pop();
        }
    }
}