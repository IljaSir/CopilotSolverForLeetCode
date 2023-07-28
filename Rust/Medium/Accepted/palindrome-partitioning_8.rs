impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut ans = Vec::new();
        let mut path = Vec::new();
        let n = s.len();
        if n == 0 {
            return ans;
        }
        let s = s.as_bytes();
        Self::dfs(s, 0, &mut path, &mut ans);
        ans
    }
    fn dfs(s: &[u8], start: usize, path: &mut Vec<String>, ans: &mut Vec<Vec<String>>) {
        if start == s.len() {
            ans.push(path.clone());
            return;
        }
        for i in start..s.len() {
            if Self::is_palindrome(s, start, i) {
                path.push(String::from_utf8(s[start..=i].to_vec()).unwrap());
                Self::dfs(s, i + 1, path, ans);
                path.pop();
            }
        }
    }
    fn is_palindrome(s: &[u8], left: usize, right: usize) -> bool {
        let mut l = left;
        let mut r = right;
        while l < r {
            if s[l] != s[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }
        true
    }
}