impl Solution {
    pub fn trailing_zeroes(n: i32) -> i32 {
        

        if n == 0 {
            return 0;
        }
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            n /= 5;
            count += n;
        }
        count
    }
}