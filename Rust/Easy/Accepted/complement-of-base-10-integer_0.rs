impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        
        if n == 0 {
            return 1;
        }
        let mut n = n;
        let mut res = 0;
        let mut i = 0;
        while n > 0 {
            if n % 2 == 0 {
                res += 2i32.pow(i);
            }
            n /= 2;
            i += 1;
        }
        res
    }
}