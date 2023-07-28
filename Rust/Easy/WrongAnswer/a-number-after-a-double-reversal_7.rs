impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut reversed = 0;
        let mut num = num;
        while num > 0 {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        reversed == num || reversed / 10 == num
    }
}