impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        while n > 4 {
            let mut min = n;
            let mut x = n;
            let mut i = 2;
            while i * i <= x {
                if x % i == 0 {
                    let mut sum = 0;
                    while x % i == 0 {
                        sum += i;
                        x /= i;
                    }
                    min = min.min(sum);
                }
                i += 1;
            }
            if x > 1 {
                min = min.min(x);
            }
            n = min;
        }
        n
    }
}