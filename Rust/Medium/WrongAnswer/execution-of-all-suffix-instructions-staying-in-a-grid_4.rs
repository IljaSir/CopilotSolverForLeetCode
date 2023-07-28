impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut pos = start_pos.clone();
        for (i, c) in s.chars().enumerate() {
            let mut pos1 = pos.clone();
            match c {
                'L' => pos1[1] -= 1,
                'R' => pos1[1] += 1,
                'U' => pos1[0] -= 1,
                'D' => pos1[0] += 1,
                _ => (),
            }
            if pos1[0] >= 0 && pos1[0] < n && pos1[1] >= 0 && pos1[1] < n {
                res[i] = 1;
                pos = pos1;
            }
        }
        let mut sum = 0;
        for i in (0..res.len()).rev() {
            sum += res[i];
            res[i] = sum;
        }
        res
    }
}