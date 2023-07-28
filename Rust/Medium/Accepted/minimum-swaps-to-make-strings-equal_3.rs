impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        for i in 0..s1.len() {
            if s1.as_bytes()[i] == s2.as_bytes()[i] {
                continue;
            }
            if s1.as_bytes()[i] == b'x' {
                x += 1;
            } else {
                y += 1;
            }
        }
        if (x + y) % 2 == 1 {
            return -1;
        }
        x / 2 + y / 2 + (x % 2) * 2
    }
}