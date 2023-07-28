impl Solution {
    pub fn fib(n: i32) -> i32 {
        
        if n == 0 {
            return 0;
        }
        if n == 1 {
            return 1;
        }
        let mut a = 0;
        let mut b = 1;
        let mut res = 0;
        for _ in 1..n {
            res = a + b;
            a = b;
            b = res;
        }
        res
    }
}