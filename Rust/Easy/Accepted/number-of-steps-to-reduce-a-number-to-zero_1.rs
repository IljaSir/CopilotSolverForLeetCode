impl Solution {
    pub fn number_of_steps(num: i32) -> i32 {
        
        if num == 0 {
            return 0;
        }
        if num % 2 == 0 {
            return 1 + Self::number_of_steps(num / 2);
        } else {
            return 1 + Self::number_of_steps(num - 1);
        }
    }
}