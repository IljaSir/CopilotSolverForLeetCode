impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut dx = 0;
        let mut dy = 1;
        for c in instructions.chars() {
            match c {
                'G' => {
                    x += dx;
                    y += dy;
                },
                'L' => {
                    let tmp = dx;
                    dx = -dy;
                    dy = tmp;
                },
                'R' => {
                    let tmp = dx;
                    dx = dy;
                    dy = -tmp;
                },
                _ => (),
            }
        }
        (x == 0 && y == 0) || (dx != 0 || dy != 1)
    }
}