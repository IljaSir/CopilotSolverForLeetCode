impl Solution {
    pub fn is_power_of_four(n: i32) -> bool {
        
        if n == 1 {
            return true;
        }
        if n % 4 != 0 || n < 4 {
            return false;
        }
        return Self::is_power_of_four(n / 4);
    }
}