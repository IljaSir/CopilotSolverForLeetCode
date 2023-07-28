impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut t = target;
        let mut r = 0;
        while t > start_value {
            if t % 2 == 0 {
                t /= 2;
            } else {
                t += 1;
            }
            r += 1;
        }
        r + start_value - t
    }
}