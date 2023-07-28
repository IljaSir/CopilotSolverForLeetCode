impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let s = s.as_bytes();
        let mut left = 0;
        let mut right = 0;
        for i in 0..s.len() {
            let len1 = Self::expand_around_center(s, i, i);
            let len2 = Self::expand_around_center(s, i, i + 1);
            let len = len1.max(len2);
            if len > right - left {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        String::from_utf8(s[left..=right].to_vec()).unwrap()
    }
    fn expand_around_center(s: &[u8], mut left: usize, mut right: usize) -> usize {
        while left > 0 && right < s.len() - 1 && s[left - 1] == s[right + 1] {
            left -= 1;
            right += 1;
        }
        right - left + 1
    }
}