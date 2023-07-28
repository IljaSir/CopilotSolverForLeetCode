impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let mut ans = 0;
        let s: Vec<char> = s.chars().collect();
        for i in 0..s.len() {
            let mut l = i;
            let mut r = i;
            while l > 0 && r < s.len() - 1 && s[l - 1] == s[r + 1] {
                l -= 1;
                r += 1;
                ans += 1;
            }
            ans += 1;
            l = i;
            r = i + 1;
            while l > 0 && r < s.len() && s[l - 1] == s[r] {
                l -= 1;
                r += 1;
                ans += 1;
            }
        }
        ans
    }
}