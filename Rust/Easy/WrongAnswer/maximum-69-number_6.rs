impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num = num;
        let mut n = 0;
        let mut i = 1;
        while num > 0 {
            let r = num % 10;
            if r == 6 {
                n = i;
            }
            num /= 10;
            i *= 10;
        }
        if n > 0 {
            num + 3 * n
        } else {
            num
        }
    }
}