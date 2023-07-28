impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut target = target;
        let mut ans = 0;
        while target > start_value {
            ans += 1;
            if target % 2 == 1 {
                target += 1;
            } else {
                target /= 2;
            }
        }
        ans + start_value - target
    }
}