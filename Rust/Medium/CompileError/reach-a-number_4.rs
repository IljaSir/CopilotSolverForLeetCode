impl Solution {
    pub fn reach_number(target: i32) -> i32 {
        
        let mut target = target.abs() as i64;
        let mut n = 0;
        while target > 0 {
            n += 1;
            target -= n;
        }
        if target % 2 == 0 {
            n
        } else {
            if n % 2 == 0 {
                n + 1
            } else {
                n + 2
            }
        }