impl Solution {
    pub fn is_power_of_four(n: i32) -> bool {
        
        if n == 1 {
            return true;
        }
        if n == 0 || n % 4 != 0 {
            return false;
        }
        return Solution::is_power_of_four(n / 4);
    }
}