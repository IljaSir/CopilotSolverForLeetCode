impl Solution {
    pub fn is_robot_bounded(instructions: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut dir = 0;
        let dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)];
        for c in instructions.chars() {
            match c {
                'G' => {
                    x += dirs[dir].0;
                    y += dirs[dir].1;
                },
                'L' => dir = (dir + 3) % 4,
                'R' => dir = (dir + 1) % 4,
                _ => (),
            }
        }
        x == 0 && y == 0 || dir != 0
    }
}