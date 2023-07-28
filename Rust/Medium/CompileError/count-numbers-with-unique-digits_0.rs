impl Solution {
    pub fn count_numbers_with_unique_digits(n: i32) -> i32 {
        

        let mut ans = 1;
        let mut unique_digits = 9;
        let mut available_number = 9;
        while n > 0 && available_number > 0 {
            unique_digits *= available_number;
            ans += unique_digits;
            available_number -= 1;
            n -= 1;
        }
        ans
    }
}