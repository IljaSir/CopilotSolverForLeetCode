impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut a = 1;
        let mut b = 1;
        let mut c = 2;
        let mut fib = vec![a, b];
        while c <= k {
            fib.push(c);
            a = b;
            b = c;
            c = a + b;
        }
        let mut k = k;
        let mut ans = 0;
        for i in (0..fib.len()).rev() {
            if k >= fib[i] {
                k -= fib[i];
                ans += 1;
            }
        }
        ans
    }
}