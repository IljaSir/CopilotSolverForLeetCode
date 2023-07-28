impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fib = vec![1, 1];
        while fib.last().unwrap() < &k {
            fib.push(fib[fib.len() - 1] + fib[fib.len() - 2]);
        }
        let mut ans = 0;
        let mut k = k as i64;
        for i in (0..fib.len()).rev() {
            if fib[i] <= k {
                ans += 1;
                k -= fib[i];
            }
            if k == 0 {
                break;
            }
        }
        ans
    }
}