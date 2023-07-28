impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut res = Vec::new();
        let mut path = Vec::new();
        let chars: Vec<char> = s.chars().collect();
        Self::backtrack(&chars, 0, &mut path, &mut res);
        res
    }

    fn backtrack(chars: &[char], start: usize, path: &mut Vec<String>, res: &mut Vec<String>) {
        if path.len() == 4 {
            if start == chars.len() {
                res.push(path.join("."));
            }
            return;
        }
        for i in start..chars.len() {
            if i > start && chars[start] == '0' {
                break;
            }
            let str = chars[start..=i].iter().collect::<String>();
            let num = str.parse::<i32>().unwrap();
            if num <= 255 {
                path.push(str);
                Self::backtrack(chars, i + 1, path, res);
                path.pop();
            }
        }
    }
}