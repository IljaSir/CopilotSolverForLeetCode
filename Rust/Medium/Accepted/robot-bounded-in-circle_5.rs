impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut dir = 0;
        for i in instructions.chars() {
            match i {
                'G' => {
                    match dir {
                        0 => y += 1,
                        1 => x += 1,
                        2 => y -= 1,
                        3 => x -= 1,
                        _ => {}
                    }
                }
                'L' => {
                    dir = (dir + 3) % 4;
                }
                'R' => {
                    dir = (dir + 1) % 4;
                }
                _ => {}
            }
        }
        x == 0 && y == 0 || dir != 0
    }
}