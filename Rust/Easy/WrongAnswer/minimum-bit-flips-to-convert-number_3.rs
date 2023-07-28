impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut flips = 0;
        let mut flip = 0;
        for i in 0..32 {
            let a = (start >> i) & 1;
            let b = (goal >> i) & 1;
            if a == b {
                flip = 0;
            } else {
                if flip == 0 {
                    flip = 1;
                    flips += 1;
                } else {
                    flip = 0;
                }
            }
        }
        flips
    }
}