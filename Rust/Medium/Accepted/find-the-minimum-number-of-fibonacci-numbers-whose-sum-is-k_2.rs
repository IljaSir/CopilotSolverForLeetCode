impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fib = vec![1, 1];
        while fib.last().unwrap() < &k {
            fib.push(fib[fib.len() - 1] + fib[fib.len() - 2]);
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