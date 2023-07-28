impl Solution {
    pub fn last_remaining(n: i32) -> i32 {
        

        if n == 1 {
            return 1;
        }
        let mut n = n;
        let mut i = 1;
        let mut left = true;
        let mut res = 0;
        while n > 1 {
            if left || n % 2 == 1 {
                res += i;
            }
            n /= 2;
            i *= 2;
            left = !left;
        }
        res
    }
}