impl Solution {
    pub fn possibly_equals(s1: String, s2: String) -> bool {
        
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        Self::dfs(s1, s2, 0, 0)
    }
    fn dfs(s1: &[u8], s2: &[u8], i: usize, j: usize) -> bool {
        let mut i = i;
        let mut j = j;
        while i < s1.len() && j < s2.len() && s1[i] == s2[j] {
            i += 1;
            j += 1;
        }
        if i == s1.len() && j == s2.len() {
            return true;
        }
        if i == s1.len() || j == s2.len() || !s1[i].is_ascii_digit() || !s2[j].is_ascii_digit() {
            return false;
        }
        let mut i = i;
        let mut j = j;
        let mut k = 0;
        while i < s1.len() && s1[i].is_ascii_digit() {
            k = k * 10 + (s1[i] - b'0') as usize;
            i += 1;
        }
        let mut l = 0;
        while j < s2.len() && s2[j].is_ascii_digit() {
            l = l * 10 + (s2[j] - b'0') as usize;
            j += 1;
        }
        if k == l && Self::dfs(s1, s2, i, j) {
            return true;
        }
        if k < l && Self::dfs(&s1[i..], &s2[j..], 0, 0) {
            return true;
        }
        if k > l && Self::dfs(&s1[i..], &s2[j..], 0, 0) {
            return true;
        }
        false
    }
}