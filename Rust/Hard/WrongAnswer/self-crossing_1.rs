impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        
        if distance.len() < 4 {
            return false;
        }
        let mut x = 0;
        let mut y = 0;
        let mut x1 = 0;
        let mut y1 = 0;
        let mut x2 = 0;
        let mut y2 = 0;
        let mut x3 = 0;
        let mut y3 = 0;
        for i in 0..distance.len() {
            match i % 4 {
                0 => {
                    y += distance[i];
                    if i > 3 && x >= x3 && x <= x3 + distance[i - 3] && y >= y3 && y <= y3 + distance[i - 2] {
                        return true;
                    }
                }
                1 => {
                    x -= distance[i];
                    if i > 3 && x >= x3 && x <= x3 + distance[i - 3] && y >= y3 && y <= y3 + distance[i - 2] {
                        return true;
                    }
                }
                2 => {
                    y -= distance[i];
                    if i > 3 && x >= x3 && x <= x3 + distance[i - 3] && y >= y3 && y <= y3 + distance[i - 2] {
                        return true;
                    }
                }
                3 => {
                    x += distance[i];
                    if i > 3 && x >= x3 && x <= x3 + distance[i - 3] && y >= y3 && y <= y3 + distance[i - 2] {
                        return true;
                    }
                }
                _ => {}
            }
            x3 = x2;
            y3 = y2;
            x2 = x1;
            y2 = y1;
            x1 = x;
            y1 = y;
        }
        false
    }
}