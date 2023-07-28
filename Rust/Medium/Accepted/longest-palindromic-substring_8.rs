impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let mut max_len = 0;
        let mut max_start = 0;
        let mut max_end = 0;
        let mut i = 0;
        let s = s.as_bytes();
        while i < s.len() {
            let mut j = i;
            let mut k = i;
            while k < s.len() - 1 && s[k] == s[k + 1] {
                k += 1;
            }
            i = k + 1;
            while j > 0 && k < s.len() - 1 && s[j - 1] == s[k + 1] {
                j -= 1;
                k += 1;
            }
            if k - j + 1 > max_len {
                max_len = k - j + 1;
                max_start = j;
                max_end = k;
            }
        }
        String::from_utf8(s[max_start..=max_end].to_vec()).unwrap()
    }
}