impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut n = num;
        let mut reverse = 0;
        while n > 0 {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        num == reverse || (num + reverse) % 10 == 0
    }
}