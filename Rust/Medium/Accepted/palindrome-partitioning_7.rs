impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        

        let mut ans = Vec::new();
        let mut cur = Vec::new();
        let s = s.as_bytes();
        Self::dfs(s, 0, &mut ans, &mut cur);
        ans
    }
    fn dfs(s: &[u8], i: usize, ans: &mut Vec<Vec<String>>, cur: &mut Vec<String>) {
        if i == s.len() {
            ans.push(cur.clone());
            return;
        }
        for j in i..s.len() {
            if Self::is_palindrome(s, i, j) {
                let ss = unsafe { std::str::from_utf8_unchecked(&s[i..j+1]) };
                cur.push(ss.to_string());
                Self::dfs(s, j+1, ans, cur);
                cur.pop();
            }
        }
    }
    fn is_palindrome(s: &[u8], i: usize, j: usize) -> bool {
        let mut i = i;
        let mut j = j;
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