impl Solution {
    pub fn smallest_value(n: i32) -> i32 {
        
        let mut n = n;
        let mut v = vec![];
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                v.push(i);
                n /= i;
            } else {
                i += 1;
            }
        }
        if n > 1 {
            v.push(n);
        }
        v.iter().sum()
    }
}