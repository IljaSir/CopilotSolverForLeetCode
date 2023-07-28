impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut num = num;
        let mut reversed = 0;
        while num > 0 {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        num = num;
        reversed = reversed;
        while num > 0 {
            if num % 10 != reversed % 10 {
                return false;
            }
            num /= 10;
            reversed /= 10;
        }
        true
    }
}