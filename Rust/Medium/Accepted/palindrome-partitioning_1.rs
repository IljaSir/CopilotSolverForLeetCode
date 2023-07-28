impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut res = Vec::new();
        let mut stack = Vec::new();
        Self::dfs(s.as_bytes(), 0, &mut stack, &mut res);
        res
    }

    fn dfs(s: &[u8], start: usize, stack: &mut Vec<String>, res: &mut Vec<Vec<String>>) {
        if start == s.len() {
            res.push(stack.clone());
            return;
        }

        for i in start..s.len() {
            if Self::is_palindrome(s, start, i) {
                stack.push(String::from_utf8_lossy(&s[start..=i]).to_string());
                Self::dfs(s, i + 1, stack, res);
                stack.pop();
            }
        }
    }

    fn is_palindrome(s: &[u8], start: usize, end: usize) -> bool {
        let mut i = start;
        let mut j = end;
        while i < j {
            if s[i] != s[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        true
    }
}