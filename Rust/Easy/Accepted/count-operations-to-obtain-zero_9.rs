impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let mut m = num1;
        let mut n = num2;
        let mut count = 0;
        while m != 0 && n != 0 {
            if m >= n {
                count += m / n;
                m %= n;
            } else {
                count += n / m;
                n %= m;
            }
        }
        count
    }
}