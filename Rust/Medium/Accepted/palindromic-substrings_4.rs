impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let s = s.as_bytes();
        let mut count = 0;
        for i in 0..s.len() {
            count += 1;
            let mut j = 1;
            while i >= j && i + j < s.len() && s[i - j] == s[i + j] {
                count += 1;
                j += 1;
            }
            j = 0;
            while i + 1 < s.len() && s[i] == s[i + 1] && i >= j && i + j + 1 < s.len() && s[i - j] == s[i + j + 1] {
                count += 1;
                j += 1;
            }
        }
        count
    }
}