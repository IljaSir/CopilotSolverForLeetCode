impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut a = 1;
        let mut c = 0;
        while a != 1 || c == 0 {
            if a < n / 2 {
                a *= 2;
            } else {
                a = a * 2 - n + 1;
            }
            c += 1;
        }
        c
    }
}