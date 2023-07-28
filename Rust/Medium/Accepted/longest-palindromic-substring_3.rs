impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let mut max = 0;
        let mut start = 0;
        let mut end = 0;
        let s = s.as_bytes();
        for i in 0..s.len() {
            let mut j = 0;
            while i >= j && i + j < s.len() && s[i - j] == s[i + j] {
                if 2 * j + 1 > max {
                    max = 2 * j + 1;
                    start = i - j;
                    end = i + j + 1;
                }
                j += 1;
            }
            j = 1;
            while i >= j && i + j - 1 < s.len() && s[i - j] == s[i + j - 1] {
                if 2 * j > max {
                    max = 2 * j;
                    start = i - j;
                    end = i + j;
                }
                j += 1;
            }
        }
        String::from_utf8(s[start..end].to_vec()).unwrap()
    }
}