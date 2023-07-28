impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut cnt = 0;
        let mut cur = 1;
        let mut pre = 0;
        let mut chars = s.chars();
        let mut last = chars.next();
        for c in chars {
            if c == last.unwrap() {
                cur += 1;
            } else {
                cnt += std::cmp::min(pre, cur);
                pre = cur;
                cur = 1;
            }
            last = Some(c);
        }
        cnt + std::cmp::min(pre, cur)
    }
}