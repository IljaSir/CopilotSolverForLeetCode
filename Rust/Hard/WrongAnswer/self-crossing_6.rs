impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        
        let mut distances = distance;
        let mut i = 0;
        let mut x = 0;
        let mut y = 0;
        let mut direction = 0;
        let mut x_min = 0;
        let mut x_max = 0;
        let mut y_min = 0;
        let mut y_max = 0;
        while i < distances.len() {
            match direction {
                0 => {
                    y += distances[i];
                    if y > y_max {
                        y_max = y;
                    }
                    if y >= 0 {
                        if x >= x_min && x <= x_max && y >= y_min && y <= y_max {
                            return true;
                        }
                    }
                },
                1 => {
                    x -= distances[i];
                    if x < x_min {
                        x_min = x;
                    }
                    if x <= 0 {
                        if x >= x_min && x <= x_max && y >= y_min && y <= y_max {
                            return true;
                        }
                    }
                },
                2 => {
                    y -= distances[i];
                    if y < y_min {
                        y_min = y;
                    }
                    if y <= 0 {
                        if x >= x_min && x <= x_max && y >= y_min && y <= y_max {
                            return true;
                        }
                    }
                },
                3 => {
                    x += distances[i];
                    if x > x_max {
                        x_max = x;
                    }
                    if x >= 0 {
                        if x >= x_min && x <= x_max && y >= y_min && y <= y_max {
                            return true;
                        }
                    }
                },
                _ => {},
            }
            direction = (direction + 1) % 4;
            i += 1;
        }
        false
    }
}