impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let (mut a, mut b) = (num1, num2);
        if a < b {
            std::mem::swap(&mut a, &mut b);
        }
        let mut ans = 0;
        loop {
            if a == 0 {
                break;
            }
            if b == 0 {
                ans += a;
                break;
            }
            let q = a / b;
            let r = a % b;
            ans += q;
            a = b;
            b = r;
        }
        ans
    }
}