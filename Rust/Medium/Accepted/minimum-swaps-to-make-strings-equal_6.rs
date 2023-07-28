impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        for i in 0..s1.len() {
            if s1[i] == s2[i] { continue; }
            if s1[i] == b'x' { a += 1; } else { b += 1; }
        }
        let mut ans = 0;
        ans += a / 2;
        ans += b / 2;
        a %= 2;
        b %= 2;
        if a == b {
            ans += a * 2;
        } else {
            ans = -1;
        }
        ans
    }
}