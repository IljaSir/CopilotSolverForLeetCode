impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        for c in s.chars() {
            if c == 'a' {
                a += 1;
            } else {
                b = b.max(a);
            }
        }
        b.max(a) - a
    }
}