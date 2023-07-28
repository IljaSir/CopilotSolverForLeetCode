impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut b = 0;
        let mut a = 0;
        for c in s.chars() {
            if c == 'b' {
                a += 1;
            } else {
                a = a.min(b);
                b += 1;
            }
        }
        a.min(b)
    }
}