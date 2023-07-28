impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let s = s.as_bytes();
        let mut ans = 0;
        let n = s.len();
        for i in 0..n {
            let mut j = 0;
            while i >= j && i + j < n && s[i - j] == s[i + j] {
                ans += 1;
                j += 1;
            }
            let mut j = 0;
            while i >= j && i + j + 1 < n && s[i - j] == s[i + j + 1] {
                ans += 1;
                j += 1;
            }
        }
        ans
    }
}