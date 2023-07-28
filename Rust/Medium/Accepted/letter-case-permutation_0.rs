impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut res = vec![];
        Self::dfs(s.as_bytes(), 0, &mut res);
        res
    }
    
    fn dfs(s: &[u8], i: usize, res: &mut Vec<String>) {
        if i == s.len() {
            res.push(String::from_utf8(s.to_vec()).unwrap());
            return;
        }
        if s[i].is_ascii_alphabetic() {
            let mut s = s.to_vec();
            s[i] = s[i].to_ascii_lowercase();
            Self::dfs(&s, i+1, res);
            s[i] = s[i].to_ascii_uppercase();
            Self::dfs(&s, i+1, res);
        } else {
            Self::dfs(s, i+1, res);
        }
    }
}