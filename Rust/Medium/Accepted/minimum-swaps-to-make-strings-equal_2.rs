impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let (mut x1, mut y1) = (0, 0);
        let (mut x2, mut y2) = (0, 0);
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            if c1 == 'x' && c2 == 'y' {
                x1 += 1;
            } else if c1 == 'y' && c2 == 'x' {
                y1 += 1;
            }
        }
        if (x1 + y1) % 2 == 1 {
            return -1;
        }
        x2 = x1 / 2;
        y2 = y1 / 2;
        x1 %= 2;
        y1 %= 2;
        x2 += x1;
        y2 += y1;
        x2 + y2
    }
}