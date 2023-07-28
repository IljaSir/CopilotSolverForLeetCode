impl Solution {
    pub fn sum_of_number_and_reverse(num: i32) -> bool {
        
        let mut num = num;
        let mut reverse = 0;
        while num > 0 {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        let mut sum = num + reverse;
        while sum > 0 {
            if sum % 10 != 0 {
                return false;
            }
            sum /= 10;
        }
        true
    }
}