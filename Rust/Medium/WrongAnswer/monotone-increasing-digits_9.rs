impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut n = n;
        let mut ans = 0;
        let mut base = 1;
        while n > 0 {
            let cur = n % 10;
            n /= 10;
            let mut tmp = n % 10;
            if tmp > cur {
                tmp -= 1;
                n -= 1;
            }
            ans += (tmp * base) + (9 * base);
            base *= 10;
        }
        ans
    }
}