impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        
        let mut sum = 0;
        for i in 1..=n {
            if Self::is_good(i) {
                sum += 1;
            }
        }
        sum
    }
    fn is_good(n: i32) -> bool {
        let mut n = n;
        let mut good = false;
        while n > 0 {
            let last = n % 10;
            n /= 10;
            match last {
                3 | 4 | 7 => return false,
                2 | 5 | 6 | 9 => good = true,
                _ => {}
            }
        }
        good
    }
}