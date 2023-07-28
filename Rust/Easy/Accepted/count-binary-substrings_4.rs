impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut last = 0;
        let mut cur = 1;
        let mut ans = 0;
        let s = s.chars().collect::<Vec<char>>();
        for i in 1..s.len() {
            if s[i] == s[i - 1] {
                cur += 1;
            } else {
                last = cur;
                cur = 1;
            }
            if last >= cur {
                ans += 1;
            }
        }
        ans
    }
}