impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut cnt = 0;
        for i in 1..=n {
            if Self::is_good(i) {
                cnt += 1;
            }
        }
        cnt
    }
    fn is_good(n: i32) -> bool {
        let mut n = n;
        let mut good = false;
        while n > 0 {
            let r = n % 10;
            if r == 3 || r == 4 || r == 7 {
                return false;
            } else if r == 2 || r == 5 || r == 6 || r == 9 {
                good = true;
            }
            n /= 10;
        }
        good
    }
}