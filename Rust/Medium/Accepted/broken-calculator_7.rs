impl Solution {
    pub fn broken_calc(start_value: i32, target: i32) -> i32 {
        
        let mut cnt = 0;
        let mut val = target;
        while val > start_value {
            if val % 2 == 0 {
                val /= 2;
            } else {
                val += 1;
            }
            cnt += 1;
        }
        cnt + start_value - val
    }
}