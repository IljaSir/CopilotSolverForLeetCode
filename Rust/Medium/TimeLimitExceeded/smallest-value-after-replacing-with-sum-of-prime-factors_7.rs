impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        while n > 4 {
            let mut t = n;
            let mut sum = 0;
            for i in 2..=n {
                if i * i > n {
                    break;
                }
                while n % i == 0 {
                    n /= i;
                    sum += i;
                }
            }
            if n > 1 {
                sum += n;
            }
            n = sum;
        }
        n
    }
}