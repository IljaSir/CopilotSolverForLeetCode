impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut b = 0;
        let mut a = 0;
        for c in s {
            if c == 'b' {
                b += 1;
            } else {
                if b > 0 {
                    b -= 1;
                    a += 1;
                }
            }
        }
        a
    }
}