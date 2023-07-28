impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut n = num;
        let mut rev = 0;
        while n > 0 {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        let mut i = 0;
        while i <= num {
            if i + rev == num {
                return true;
            }
            i += 1;
            rev += 1;
        }
        false
    }
}