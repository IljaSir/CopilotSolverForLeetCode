impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let mut a = num1;
        let mut b = num2;
        let mut count = 0;
        if a < b {
            let temp = a;
            a = b;
            b = temp;
        }
        while b != 0 {
            let q = a / b;
            let r = a % b;
            count += q;
            a = b;
            b = r;
        }
        count
    }
}