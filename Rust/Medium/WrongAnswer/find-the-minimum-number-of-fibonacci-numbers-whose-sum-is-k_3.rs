impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fib = vec![1, 1];
        while fib[fib.len() - 1] <= k {
            fib.push(fib[fib.len() - 1] + fib[fib.len() - 2]);
        }
        let mut k = k;
        let mut res = 0;
        while k > 0 {
            let idx = fib.binary_search(&(k as i32)).unwrap_or_else(|x| x);
            let idx = idx - 1;
            k -= fib[idx];
            res += 1;
        }
        res
    }
}