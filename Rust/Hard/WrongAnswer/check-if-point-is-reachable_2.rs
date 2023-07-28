impl Solution {
    pub fn is_reachable(target_x: i32, target_y: i32) -> bool {
        
        let mut x = 1;
        let mut y = 1;
        while x < target_x || y < target_y {
            if x < target_x && y < target_y {
                if target_x - x > target_y - y {
                    x += y;
                } else {
                    y += x;
                }
            } else if x < target_x {
                x += y;
            } else {
                y += x;
            }
        }
        x == target_x && y == target_y
    }
}