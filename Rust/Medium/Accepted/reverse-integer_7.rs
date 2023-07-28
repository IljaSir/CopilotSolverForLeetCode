impl Solution {
    pub fn reverse(x: i32) -> i32 {
        

        let mut x = x;
        let mut r = 0;
        while x != 0 {
            let t = x % 10;
            x /= 10;
            if r > i32::MAX / 10 || (r == i32::MAX / 10 && t > 7) {
                return 0;
            }
            if r < i32::MIN / 10 || (r == i32::MIN / 10 && t < -8) {
                return 0;
            }
            r = r * 10 + t;
        }
        r
    }
}