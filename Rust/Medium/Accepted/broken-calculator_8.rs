impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut target = target;
        let mut start_value = start_value;
        let mut res = 0;
        while target > start_value {
            if target % 2 == 0 {
                target /= 2;
            } else {
                target += 1;
            }
            res += 1;
        }
        res + start_value - target
    }
}