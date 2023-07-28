impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut pos = start_pos;
        let mut dir = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        let mut cur_dir = 0;
        for (i, c) in s.chars().enumerate() {
            let (dx, dy) = dir[cur_dir];
            match c {
                'L' => cur_dir = (cur_dir + 3) % 4,
                'R' => cur_dir = (cur_dir + 1) % 4,
                'U' => {
                    if pos[0] + dx >= 0 {
                        pos[0] += dx;
                    }
                }
                'D' => {
                    if pos[0] + dx < n {
                        pos[0] += dx;
                    }
                }
                _ => {}
            }
            res[i] = (pos[0] - start_pos[0]).abs() + (pos[1] - start_pos[1]).abs();
        }
        res
    }
}