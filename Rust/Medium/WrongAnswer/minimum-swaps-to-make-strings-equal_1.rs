impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut x1 = 0;
        let mut y1 = 0;
        let mut x2 = 0;
        let mut y2 = 0;
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            if c1 == 'x' {
                x1 += 1;
            } else {
                y1 += 1;
            }
            if c2 == 'x' {
                x2 += 1;
            } else {
                y2 += 1;
            }
        }
        if (x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0 {
            return -1;
        }
        let mut count = 0;
        if x1 % 2 == 1 {
            count += 1;
            x1 -= 1;
            y2 -= 1;
        }
        if y1 % 2 == 1 {
            count += 1;
            y1 -= 1;
            x2 -= 1;
        }
        count += x1 / 2 * 2 + y1 / 2 * 2;
        count
    }
}