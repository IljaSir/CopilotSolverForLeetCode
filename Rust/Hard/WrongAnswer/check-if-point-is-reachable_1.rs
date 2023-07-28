impl Solution {
    pub fn is_reachable(target_x: i32, target_y: i32) -> bool {
        
        let (mut x, mut y) = (target_x, target_y);
        while x > 0 && y > 0 {
            if x < y {
                std::mem::swap(&mut x, &mut y);
            }
            x %= y;
        }
        x + y == 1
    }
}