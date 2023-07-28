impl Solution {
    pub fn add_digits(num: i32) -> i32 {
        
        let mut num = num;
        while num >= 10 {
            num = num / 10 + num % 10;
        }
        num
    }
}