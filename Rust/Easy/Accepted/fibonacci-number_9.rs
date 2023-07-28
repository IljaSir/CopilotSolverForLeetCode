impl Solution {
    pub fn fib(n: i32) -> i32 {
        
        let mut a: i32 = 0;
        let mut b: i32 = 1;
        for _ in 0..n {
            let c = b;
            b = a + b;
            a = c;
        }
        a
    }
}