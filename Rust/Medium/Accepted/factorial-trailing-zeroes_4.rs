impl Solution {
    pub fn trailing_zeroes(n: i32) -> i32 {
        

        let mut n = n;
        let mut result = 0;
        while n > 0 {
            n /= 5;
            result += n;
        }
        result
    }
}