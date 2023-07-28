impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut count = 0;
        let mut cur = target;
        while cur > start_value {
            if cur % 2 == 0 {
                cur /= 2;
            } else {
                cur += 1;
            }
            count += 1;
        }
        count + start_value - cur
    }
}