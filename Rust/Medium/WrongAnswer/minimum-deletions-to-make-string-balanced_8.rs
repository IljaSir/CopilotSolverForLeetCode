impl Solution {
    pub fn minimum_deletions(s: String) -> i32 {
        
        let mut count = 0;
        let mut a = 0;
        for ch in s.chars() {
            if ch == 'b' {
                count += 1;
            } else {
                a += 1;
            }
            if a > count {
                count = a;
            }
        }
        a - count
    }
}