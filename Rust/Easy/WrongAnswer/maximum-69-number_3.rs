impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num = num;
        let mut times = 1;
        while num > 0 {
            if num % 10 == 6 {
                return num + 3 * times;
            }
            times *= 10;
            num /= 10;
        }
        num
    }
}