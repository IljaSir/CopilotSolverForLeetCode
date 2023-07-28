impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut d = 0;
        let dirs = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        for c in instructions.chars() {
            match c {
                'G' => {
                    x += dirs[d].0;
                    y += dirs[d].1;
                }
                'L' => d = (d + 3) % 4,
                'R' => d = (d + 1) % 4,
                _ => (),
            }
        }
        x == 0 && y == 0 || d != 0
    }
}