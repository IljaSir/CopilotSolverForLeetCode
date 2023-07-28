impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut n = num;
        let mut rev = 0;
        while n > 0 {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        let mut n = num;
        while n > 0 {
            if n % 10 != 0 && num % (n % 10 + rev % 10) == 0 {
                return true;
            }
            n /= 10;
            rev /= 10;
        }
        false
    }
}