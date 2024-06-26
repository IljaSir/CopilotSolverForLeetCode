impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fib = vec![1, 1];
        while fib.last().unwrap() < &k {
            fib.push(fib[fib.len() - 1] + fib[fib.len() - 2]);
        }
        let mut k = k;
        let mut res = 0;
        while k > 0 {
            if fib.last().unwrap() <= &k {
                k -= fib.pop().unwrap();
                res += 1;
            } else {
                fib.pop();
            }
        }
        res
    }
}