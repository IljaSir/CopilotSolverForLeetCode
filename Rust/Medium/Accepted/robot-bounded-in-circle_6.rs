impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut dir = 0;
        let dirs = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        for &c in instructions.as_bytes() {
            match c {
                b'G' => {
                    x += dirs[dir].0;
                    y += dirs[dir].1;
                }
                b'L' => {
                    dir = (dir + 3) % 4;
                }
                b'R' => {
                    dir = (dir + 1) % 4;
                }
                _ => {}
            }
        }
        (x == 0 && y == 0) || dir != 0
    }
}