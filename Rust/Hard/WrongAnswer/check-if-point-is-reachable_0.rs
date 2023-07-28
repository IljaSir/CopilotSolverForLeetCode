impl Solution {
    pub fn is_reachable(target_x: i32, target_y: i32) -> bool {
        
        let (mut x, mut y) = (1, 1);
        while x <= target_x && y <= target_y {
            if x == target_x && y == target_y {
                return true;
            }
            if x < y {
                x += y;
            } else if x > y {
                y += x;
            } else {
                x *= 2;
            }
        }
        false
    }
}