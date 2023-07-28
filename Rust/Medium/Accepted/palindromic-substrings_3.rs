impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let s = s.as_bytes();
        let n = s.len();
        let mut ans = 0;
        for i in 0..n {
            let mut l = 0;
            while i >= l && i + l < n && s[i - l] == s[i + l] {
                l += 1;
                ans += 1;
            }
            let mut l = 0;
            while i + 1 < n && i >= l && i + 1 + l < n && s[i - l] == s[i + 1 + l] {
                l += 1;
                ans += 1;
            }
        }
        ans as i32
    }
}