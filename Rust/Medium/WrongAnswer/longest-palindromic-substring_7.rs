impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let mut res = "";
        let mut max = 0;
        for i in 0..s.len() {
            let mut l = i;
            let mut r = i;
            while l > 0 && r < s.len() - 1 && s.as_bytes()[l - 1] == s.as_bytes()[r + 1] {
                l -= 1;
                r += 1;
            }
            if r - l + 1 > max {
                max = r - l + 1;
                res = &s[l..r + 1];
            }
            l = i;
            r = i + 1;
            while l > 0 && r < s.len() - 1 && s.as_bytes()[l - 1] == s.as_bytes()[r + 1] {
                l -= 1;
                r += 1;
            }
            if r - l + 1 > max {
                max = r - l + 1;
                res = &s[l..r + 1];
            }
        }
        res.to_string()
    }
}