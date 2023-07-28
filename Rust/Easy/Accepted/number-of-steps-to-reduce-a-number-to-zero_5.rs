impl Solution {
    pub fn number_of_steps(num: i32) -> i32 {
        
        let mut count = 0;
        let mut num = num;
        while num > 0 {
            if num % 2 == 0 {
                num /= 2;
            } else {
                num -= 1;
            }
            count += 1;
        }
        count
    }
}