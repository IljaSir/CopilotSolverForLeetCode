impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut s = start;
        let mut g = goal;
        let mut ans = 0;
        let mut last = 0;
        let mut i = 0;
        while s != 0 || g != 0 {
            let a = s % 2;
            let b = g % 2;
            s /= 2;
            g /= 2;
            if a == b {
                last = 0;
            } else {
                if last == 0 {
                    ans += 1;
                    last = 1;
                } else {
                    last = 0;
                }
            }
            i += 1;
        }
        ans
    }
}