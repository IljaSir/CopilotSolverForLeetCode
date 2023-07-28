impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut n = num;
        let mut rev = 0;
        while n > 0 {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        let mut sum = num + rev;
        while sum > 0 {
            if sum % 10 != 0 && num % (sum % 10) != 0 {
                return false;
            }
            sum = sum / 10;
        }
        true
    }
}