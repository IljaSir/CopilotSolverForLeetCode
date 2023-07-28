impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            if Self::is_good(i) {
                count += 1;
            }
        }
        count
    }
    fn is_good(n: i32) -> bool {
        let mut n = n;
        let mut is_good = false;
        while n > 0 {
            match n % 10 {
                2 | 5 | 6 | 9 => is_good = true,
                3 | 4 | 7 => return false,
                _ => {}
            }
            n /= 10;
        }
        is_good
    }
}