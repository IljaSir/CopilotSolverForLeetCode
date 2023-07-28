impl Solution {
    pub fn fib(n: i32) -> i32 {
        
        if n == 0 {
            return 0;
        }
        if n == 1 {
            return 1;
        }
        let mut i = 2;
        let mut a = 0;
        let mut b = 1;
        let mut c = 0;
        while i <= n {
            c = a + b;
            a = b;
            b = c;
            i += 1;
        }
        c
    }
}