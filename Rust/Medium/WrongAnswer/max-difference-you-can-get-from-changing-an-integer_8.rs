impl Solution {
    pub fn max_diff(num: i32) -> i32 {
        
        let mut min = num;
        let mut max = num;
        let mut num = num;
        let mut i = 1;
        while num > 0 {
            let digit = num % 10;
            if digit == 9 {
                min -= 9 * i;
            } else {
                min += 9 * i;
            }
            if digit == 1 {
                max -= 1 * i;
            } else if digit > 1 {
                max += (1 - digit) * i;
            }
            i *= 10;
            num /= 10;
        }
        max - min
    }
}