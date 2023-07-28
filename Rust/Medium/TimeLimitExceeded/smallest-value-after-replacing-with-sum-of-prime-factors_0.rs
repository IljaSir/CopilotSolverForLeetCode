impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        while n > 4 {
            let mut sum = 0;
            let mut i = 2;
            while i * i <= n {
                if n % i == 0 {
                    sum += i;
                    n /= i;
                } else {
                    i += 1;
                }
            }
            n = sum + n;
        }
        n
    }
}