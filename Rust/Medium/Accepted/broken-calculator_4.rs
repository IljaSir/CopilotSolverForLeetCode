impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut x = target;
        let mut ans = 0;
        while x > start_value {
            ans += 1;
            if x % 2 == 0 {
                x /= 2;
            } else {
                x += 1;
            }
        }
        ans + start_value - x
    }
}