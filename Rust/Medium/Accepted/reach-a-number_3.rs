impl Solution {
    pub fn reach_number(target: i32) -> i32 {
        
        let mut target = target.abs();
        let mut n = 0;
        while target > 0 {
            n += 1;
            target -= n;
        }
        if target % 2 == 0 {
            n
        } else {
            n + 1 + n % 2
        }
    }
}