impl Solution {
    pub fn add_digits(num: i32) -> i32 {
        
        if num == 0 {
            return 0;
        }
        let x = num % 9;
        if x == 0 {
            return 9;
        }
        x
    }
}