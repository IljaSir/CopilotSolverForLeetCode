impl Solution {
    pub fn find_integers(n: i32) -> i32 {
        
        let mut a = 1;
        let mut b = 2;
        let mut c = 3;
        let mut n = n;
        while n > 0 {
            let t = a + b;
            a = b;
            b = c;
            c = t;
            n >>= 1;
        }
        a + b
    }
}