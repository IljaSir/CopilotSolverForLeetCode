impl Solution {
    pub fn check_powers_of_three(n: i32) -> bool {
        
        let mut n = n;
        let mut power = 0;
        while n > 0 {
            let cur = 3.pow(power);
            if n >= cur {
                n -= cur;
            }
            power += 1;
        }
        n == 0
    }
}