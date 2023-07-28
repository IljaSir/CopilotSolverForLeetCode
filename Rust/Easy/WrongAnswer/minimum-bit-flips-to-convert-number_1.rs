impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut res = 0;
        let mut cur = 0;
        for i in 0..32 {
            let s = (start >> i) & 1;
            let g = (goal >> i) & 1;
            if s == 1 && g == 1 {
                continue;
            } else if s == 0 && g == 0 {
                continue;
            } else if s == 1 && g == 0 {
                if cur == 0 {
                    res += 1;
                    cur = 1;
                } else {
                    cur = 0;
                }
            } else if s == 0 && g == 1 {
                if cur == 0 {
                    res += 1;
                } else {
                    cur = 0;
                }
            }
        }
        res
    }
}