impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut reversed1 = 0;
        let mut reversed2 = 0;
        let mut num = num;
        while num > 0 {
            reversed1 = reversed1 * 10 + num % 10;
            num /= 10;
        }
        num = reversed1;
        while num > 0 {
            reversed2 = reversed2 * 10 + num % 10;
            num /= 10;
        }
        reversed2 == reversed1
    }
}