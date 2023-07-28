impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut ans = vec![];
        let mut buf = vec![];
        Self::dfs(&mut ans, &mut buf, &s);
        ans
    }
    fn dfs(ans: &mut Vec<String>, buf: &mut Vec<char>, s: &str) {
        if buf.len() == s.len() {
            ans.push(buf.iter().collect());
            return;
        }
        let c = s.as_bytes()[buf.len()] as char;
        if c.is_ascii_alphabetic() {
            buf.push(c.to_ascii_lowercase());
            Self::dfs(ans, buf, s);
            buf.pop();
            buf.push(c.to_ascii_uppercase());
            Self::dfs(ans, buf, s);
            buf.pop();
        } else {
            buf.push(c);
            Self::dfs(ans, buf, s);
            buf.pop();
        }
    }
}