impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut ans = 0;
        let mut pre = 0;
        let mut cur = 1;
        for i in 1..s.len() {
            if s.as_bytes()[i] == s.as_bytes()[i-1] {
                cur += 1;
            } else {
                pre = cur;
                cur = 1;
            }
            if pre >= cur {
                ans += 1;
            }
        }
        ans
    }
}