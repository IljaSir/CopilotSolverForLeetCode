impl Solution {
    pub fn last_remaining(n: i32) -> i32 {
        

        if n == 1 { return 1; }
        let mut n = n;
        let mut i = 1;
        let mut left = true;
        let mut result = 1;
        while n > 1 {
            if left || n % 2 == 1 {
                result += i;
            }
            i *= 2;
            n /= 2;
            left = !left;
        }
        result
    }
}