impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut start = start;
        let mut goal = goal;
        let mut ans = 0;
        let mut rev = 0;
        while start > 0 || goal > 0 {
            let x = start % 2;
            let y = goal % 2;
            if x == y {
                rev = 0;
            } else if x == 0 && y == 1 {
                if rev == 1 {
                    rev = 0;
                } else {
                    ans += 1;
                    rev = 1;
                }
            } else {
                if rev == 1 {
                    ans += 1;
                    rev = 0;
                } else {
                    rev = 1;
                }
            }
            start /= 2;
            goal /= 2;
        }
        ans
    }
}