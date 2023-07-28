impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let (mut num1, mut num2) = (num1 as i64, num2 as i64);
        if num1 < num2 {
            std::mem::swap(&mut num1, &mut num2);
        }
        let mut count = 0;
        while num1 != 0 {
            count += num2 / num1;
            num2 %= num1;
            std::mem::swap(&mut num1, &mut num2);
        }
        count
    }
}