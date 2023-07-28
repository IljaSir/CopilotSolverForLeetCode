impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let mut a = num1;
        let mut b = num2;
        if a > b {
            std::mem::swap(&mut a, &mut b);
        }
        let mut count = 0;
        while a > 0 {
            count += b / a;
            b %= a;
            std::mem::swap(&mut a, &mut b);
        }
        count
    }
}