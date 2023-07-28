impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        
        let mut start = start;
        let mut goal = goal;
        let mut count = 0;
        let mut flip = false;
        while start > 0 || goal > 0 {
            let s = start % 2;
            let g = goal % 2;
            if flip {
                if s == 0 && g == 0 {
                    count += 1;
                    flip = !flip;
                }
                if s == 1 && g == 1 {
                    count += 1;
                    flip = !flip;
                }
            } else {
                if s == 0 && g == 1 {
                    count += 1;
                    flip = !flip;
                }
                if s == 1 && g == 0 {
                    count += 1;
                }
            }
            start /= 2;
            goal /= 2;
        }
        count
    }
}