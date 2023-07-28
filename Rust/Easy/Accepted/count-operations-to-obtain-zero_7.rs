impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let (mut a, mut b) = (num1, num2);
        if b > a {
            std::mem::swap(&mut a, &mut b);
        }
        let mut res = 0;
        while a > 0 {
            res += b / a;
            b %= a;
            std::mem::swap(&mut a, &mut b);
        }
        res
    }
}