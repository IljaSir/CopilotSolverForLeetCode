impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut i = 1;
        let mut c = 0;
        loop {
            if i == 1 {
                return c;
            }
            if i < n / 2 {
                i *= 2;
            } else {
                i = (i - n / 2) * 2 + 1;
            }
            c += 1;
        }
    }
}