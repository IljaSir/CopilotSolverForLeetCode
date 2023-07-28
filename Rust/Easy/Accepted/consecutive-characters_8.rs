impl Solution {
    pub fn max_power(s: String) -> i32 {
        
        let mut res = 1;
        let mut cnt = 1;
        let mut chars = s.chars();
        let mut pre = chars.next().unwrap();
        for c in chars {
            if c == pre {
                cnt += 1;
            } else {
                res = res.max(cnt);
                cnt = 1;
                pre = c;
            }
        }
        res.max(cnt)
    }
}