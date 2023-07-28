impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut result = Vec::new();
        let mut address = String::new();
        Self::dfs(&s, 0, 0, &mut address, &mut result);
        result
    }

    fn dfs(s: &str, start: usize, depth: usize, address: &mut String, result: &mut Vec<String>) {
        if depth == 4 {
            if start == s.len() {
                result.push(address.to_string());
            }
            return;
        }
        for i in 1..=3 {
            if start + i > s.len() {
                break;
            }
            let ip = &s[start..start + i];
            if ip.len() > 1 && ip.starts_with('0') {
                continue;
            }
            if ip.parse::<i32>().unwrap() > 255 {
                continue;
            }
            let len = address.len();
            if depth != 0 {
                address.push('.');
            }
            address.push_str(ip);
            Self::dfs(s, start + i, depth + 1, address, result);
            address.truncate(len);
        }
    }
}