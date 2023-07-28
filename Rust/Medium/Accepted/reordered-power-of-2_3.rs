impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut digits = vec![0; 10];
        let mut x = n;
        while x > 0 {
            digits[(x % 10) as usize] += 1;
            x /= 10;
        }
        for i in 0..32 {
            let mut x = 1 << i;
            let mut y = vec![0; 10];
            while x > 0 {
                y[(x % 10) as usize] += 1;
                x /= 10;
            }
            if digits == y {
                return true;
            }
        }
        false
    }
}