impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut num = num;
        let mut reversed = 0;
        while num > 0 {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        num = num;
        let mut reversed2 = 0;
        while num > 0 {
            reversed2 = reversed2 * 10 + num % 10;
            num /= 10;
        }
        reversed == reversed2
    }
}