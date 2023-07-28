impl Solution {
    pub fn is_power_of_four(n: i32) -> bool {
        
        if n == 1 {
            return true;
        }
        let mut n = n;
        while n > 0 {
            if n % 4 == 0 {
                n /= 4;
                if n == 1 {
                    return true;
                }
            } else {
                return false;
            }
        }
        false
    }
}