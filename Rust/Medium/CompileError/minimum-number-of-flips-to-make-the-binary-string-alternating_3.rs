impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.into_bytes();
        let n = s.len();
        let mut s1 = Vec::with_capacity(n);
        let mut s2 = Vec::with_capacity(n);
        for i in 0..n {
            s1.push(if i % 2 == 0 { b'1' } else { b'0' });
            s2.push(if i % 2 == 0 { b'0' } else { b'1' });
        })
    }
}