impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut res = vec![];
        let mut s = s.as_bytes().to_vec();
        Self::dfs(&mut s, 0, &mut res);
        res
    }
    
    fn dfs(s: &mut Vec<u8>, i: usize, res: &mut Vec<String>) {
        if i == s.len() {
            res.push(String::from_utf8(s.clone()).unwrap());
            return;
        }
        Self::dfs(s, i + 1, res);
        if s[i].is_ascii_alphabetic() {
            s[i] ^= 1 << 5;
            Self::dfs(s, i + 1, res);
        }
    }
}