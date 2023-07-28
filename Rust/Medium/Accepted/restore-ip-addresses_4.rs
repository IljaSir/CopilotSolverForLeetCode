impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut result = vec![];
        let mut path = vec![];
        Self::dfs(&mut result, &mut path, &s, 0);
        result
    }
    
    fn dfs(result: &mut Vec<String>, path: &mut Vec<String>, s: &str, start: usize) {
        if path.len() == 4 {
            if start == s.len() {
                result.push(path.join("."));
            }
            return;
        }
        
        for i in 1..=3 {
            if start + i > s.len() {
                break;
            }
            let part = &s[start..start+i];
            if (part.starts_with('0') && part.len() > 1) || part.parse::<i32>().unwrap() > 255 {
                continue;
            }
            path.push(part.to_string());
            Self::dfs(result, path, s, start+i);
            path.pop();
        }
    }
}