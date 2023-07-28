impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut n = num;
        let mut max = 0;
        let mut p = 1;
        while n > 0 {
            let d = n % 10;
            if d == 6 {
                max = p * 3;
            }
            n /= 10;
            p *= 10;
        }
        num + max
    }
}