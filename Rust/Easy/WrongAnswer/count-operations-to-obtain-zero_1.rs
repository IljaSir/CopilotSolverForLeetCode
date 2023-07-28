impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let (mut num1, mut num2) = (num1 as usize, num2 as usize);
        if num1 > num2 {
            std::mem::swap(&mut num1, &mut num2);
        }
        let mut count = 0;
        while num1 != 0 {
            let (q, r) = (num2 / num1, num2 % num1);
            num2 = num1;
            num1 = r;
            count += q as i32;
        }
        count + num2 as i32 - 1
    }
}