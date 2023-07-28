impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut rev = 0;
        let mut n = num;
        while n > 0 {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        num == rev || num + rev == rev + num
    }
}