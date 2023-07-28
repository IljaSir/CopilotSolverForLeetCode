impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut start = start;
        let mut goal = goal;
        let mut count = 0;
        let mut flip = 0;
        while start > 0 || goal > 0 {
            let s = start & 1;
            let g = goal & 1;
            if s == g {
                flip = 0;
            } else if flip == 0 {
                flip = 1;
                count += 1;
            } else {
                flip = 0;
            }
            start >>= 1;
            goal >>= 1;
        }
        count
    }
}