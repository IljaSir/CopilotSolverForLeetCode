impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let mut s: Vec<u8> = s.bytes().collect();
        s.reverse();
        Self::dfs(&s, 0, 0)
    }
    fn dfs(s: &[u8], i: usize, n: u32) -> bool {
        if i == s.len() { return n > 0; }
        let mut x: u32 = 0;
        for j in i..s.len() {
            x = x * 10 + (s[j] - b'0') as u32;
            if n == 0 { if Self::dfs(s, j + 1, x) { return true; } }
            else if x == n - 1 { if Self::dfs(s, j + 1, x) { return true; } }
        }
        false
    }
}