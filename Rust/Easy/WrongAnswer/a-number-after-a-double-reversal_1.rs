impl Solution {
    pub fn is_same_after_reversals(num: i32) -> bool {
        
        let mut num = num;
        let mut reversed1 = 0;
        while num > 0 {
            reversed1 = reversed1 * 10 + num % 10;
            num /= 10;
        }
        let mut reversed2 = 0;
        while reversed1 > 0 {
            reversed2 = reversed2 * 10 + reversed1 % 10;
            reversed1 /= 10;
        }
        reversed2 == num
    }
}