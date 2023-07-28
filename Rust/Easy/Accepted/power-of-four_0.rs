impl Solution {
    pub fn is_power_of_four(n: i32) -> bool {
        
        if n <= 0 {
            return false;
        }
        if n == 1 {
            return true;
        }
        if n % 4 != 0 {
            return false;
        }
        return Self::is_power_of_four(n / 4);
    }
}