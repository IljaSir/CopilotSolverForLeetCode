impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut d = 0;
        for c in instructions.chars() {
            match c {
                'G' => {
                    match d {
                        0 => y += 1,
                        1 => x += 1,
                        2 => y -= 1,
                        3 => x -= 1,
                        _ => unreachable!(),
                    }
                }
                'L' => d = (d + 3) % 4,
                'R' => d = (d + 1) % 4,
                _ => unreachable!(),
            }
        }
        x == 0 && y == 0 || d != 0
    }
}