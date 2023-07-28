impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        
        let mut i = 0;
        let mut x = 0;
        let mut y = 0;
        let mut d = 0;
        let mut l = distance.len();
        let mut s = vec![(0, 0)];
        while i < l {
            match d {
                0 => {
                    y += distance[i];
                    d = 1;
                }
                1 => {
                    x -= distance[i];
                    d = 2;
                }
                2 => {
                    y -= distance[i];
                    d = 3;
                }
                3 => {
                    x += distance[i];
                    d = 0;
                }
                _ => {}
            }
            if i > 2 {
                if d == 0 && y > 0 && x <= 0 {
                    if s.iter().any(|(a, b)| a == &x && b == &y) {
                        return true;
                    }
                } else if d == 1 && y <= 0 && x < 0 {
                    if s.iter().any(|(a, b)| a == &x && b == &y) {
                        return true;
                    }
                } else if d == 2 && y < 0 && x >= 0 {
                    if s.iter().any(|(a, b)| a == &x && b == &y) {
                        return true;
                    }
                } else if d == 3 && y >= 0 && x > 0 {
                    if s.iter().any(|(a, b)| a == &x && b == &y) {
                        return true;
                    }
                }
            }
            s.push((x, y));
            i += 1;
        }
        false
    }
}