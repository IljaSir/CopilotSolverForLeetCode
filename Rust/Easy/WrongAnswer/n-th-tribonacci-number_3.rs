impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        
        let mut a = 0;
        let mut b = 1;
        let mut c = 1;
        let mut d = 0;
        for _ in 0..n {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        d
    }
}