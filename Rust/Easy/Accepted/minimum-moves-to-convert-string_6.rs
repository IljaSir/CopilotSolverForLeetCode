impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        
        let mut ans = 0;
        let mut chars = s.chars();
        while let Some(ch) = chars.next() {
            if ch == 'X' {
                ans += 1;
                chars.next();
                chars.next();
            }
        }
        ans
    }
}