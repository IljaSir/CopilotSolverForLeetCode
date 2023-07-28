impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let (mut start_value, mut target) = (start_value, target);
        let mut ans = 0;
        while target > start_value {
            ans += 1;
            if target & 1 == 0 {
                target >>= 1;
            } else {
                target += 1;
            }
        }
        ans + start_value - target
    }
}