impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let mut ans = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let mut j = 0;
            while i >= j && i + j < s.len() && s[i-j] == s[i+j] {
                ans += 1;
                j += 1;
            }
            let mut j = 0;
            while i >= j && i + j + 1 < s.len() && s[i-j] == s[i+j+1] {
                ans += 1;
                j += 1;
            }
        }
        ans as i32
    }
}