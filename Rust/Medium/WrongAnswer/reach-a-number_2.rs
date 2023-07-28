impl Solution {
    pub fn reach_number(target: i32) -> i32 {
        
        let mut t = target.abs();
        let mut k = 0;
        while t > 0 {
            k += 1;
            t -= k;
        }
        if t % 2 == 0 {
            k
        } else if (k + 1) % 2 == 0 {
            k + 1
        } else {
            k + 2
        }
    }
}