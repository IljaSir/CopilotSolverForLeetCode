impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut direction: i32 = 0;
        let mut x: i32 = 0;
        let mut y: i32 = 0;
        for ch in instructions.chars() {
            match ch {
                'G' => {
                    match direction {
                        0 => y += 1,
                        1 => x += 1,
                        2 => y -= 1,
                        3 => x -= 1,
                        _ => (),
                    }
                }
                'L' => direction = (direction + 3) % 4,
                'R' => direction = (direction + 1) % 4,
                _ => (),
            }
        }
        direction != 0 || (x == 0 && y == 0)
    }
}