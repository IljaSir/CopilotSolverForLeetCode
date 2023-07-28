impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num = num;
        let mut digits = vec![0; 10];
        while num > 0 {
            digits[(num % 10) as usize] += 1;
            num /= 10;
        }
        let mut num1 = 0;
        let mut num2 = 0;
        let mut is_num1 = true;
        for i in (0..=9).rev() {
            for _ in 0..digits[i] {
                if is_num1 {
                    num1 = num1 * 10 + i;
                } else {
                    num2 = num2 * 10 + i;
                }
                is_num1 = !is_num1;
            }
        }
        num1 + num2
    }
}