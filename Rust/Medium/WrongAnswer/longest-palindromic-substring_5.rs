impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let s: Vec<char> = s.chars().collect();
        let mut ans = String::new();
        let mut ans_len = 0;
        for i in 0..s.len() {
            let (mut l, mut r) = (i, i);
            while l > 0 && r < s.len() - 1 && s[l - 1] == s[r + 1] {
                l -= 1;
                r += 1;
            }
            if r - l + 1 > ans_len {
                ans = s[l..=r].iter().collect();
                ans_len = r - l + 1;
            }
            let (mut l, mut r) = (i, i + 1);
            while l > 0 && r < s.len() && s[l - 1] == s[r] {
                l -= 1;
                r += 1;
            }
            if r - l > ans_len {
                ans = s[l..r].iter().collect();
                ans_len = r - l;
            }
        }
        ans
    }
}