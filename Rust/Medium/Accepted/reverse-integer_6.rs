impl Solution {
    pub fn reverse(x: i32) -> i32 {
        

        if x == 0 {
            return 0;
        }
        let mut x = x;
        let mut res: i64 = 0;
        while x != 0 {
            res = res * 10 + (x % 10) as i64;
            x = x / 10;
        }
        if res > i32::max_value() as i64 || res < i32::min_value() as i64 {
            return 0;
        }
        res as i32
    }
}