impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let (mut a, mut b) = if num1 > num2 { (num1, num2) } else { (num2, num1) };
        let mut count = 0;
        while a > 0 {
            count += a / b;
            a %= b;
            if a < b { std::mem::swap(&mut a, &mut b); }
        }
        count
    }
}