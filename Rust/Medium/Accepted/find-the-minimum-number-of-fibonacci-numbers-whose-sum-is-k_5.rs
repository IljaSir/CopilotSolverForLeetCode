impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fibs = vec![1, 1];
        let mut n = 1;
        while fibs[n] < k {
            n += 1;
            fibs.push(fibs[n-1] + fibs[n-2]);
        }
        let mut k = k;
        let mut result = 0;
        while k > 0 {
            while fibs[n] > k {
                n -= 1;
            }
            k -= fibs[n];
            result += 1;
        }
        result
    }
}