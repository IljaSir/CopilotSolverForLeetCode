impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut n = num;
        let mut r = 0;
        while n > 0 {
            r = r * 10 + (n % 10);
            n /= 10;
        }
        num == r
    }
}