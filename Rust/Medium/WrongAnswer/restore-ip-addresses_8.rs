impl Solution {
    pub fn restore_ip_addresses(s: String) -> Vec<String> {
        

        let mut result = Vec::new();
        let mut path = Vec::new();
        let s = s.as_bytes();
        Solution::dfs(&mut result, &mut path, s, 0);
        result
    }
    fn dfs(result: &mut Vec<String>, path: &mut Vec<String>, s: &[u8], start: usize) {
        if path.len() == 4 {
            if start == s.len() {
                result.push(path.join("."));
            }
            return;
        }
        let mut num = 0;
        for i in start..s.len() {
            if s[i] == b'0' && i > start {
                break;
            }
            num = num * 10 + (s[i] - b'0') as usize;
            if num > 255 {
                break;
            }
            path.push(num.to_string());
            Solution::dfs(result, path, s, i + 1);
            path.pop();
        }
    }
}