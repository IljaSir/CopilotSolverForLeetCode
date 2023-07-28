impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut ans = 0;
        let mut flip = 0;
        for i in 0..32 {
            let s = (start >> i) & 1;
            let g = (goal >> i) & 1;
            if s == 1 && g == 1 {
                if flip % 2 == 1 {
                    ans += 1;
                    flip += 1;
                }
            } else if s == 0 && g == 1 {
                if flip % 2 == 0 {
                    ans += 1;
                    flip += 1;
                }
            } else if s == 1 && g == 0 {
                if flip % 2 == 0 {
                    ans += 1;
                    flip += 1;
                }
            } else if s == 0 && g == 0 {
                if flip % 2 == 1 {
                    ans += 1;
                    flip += 1;
                }
            }
        }
        ans
    }
}