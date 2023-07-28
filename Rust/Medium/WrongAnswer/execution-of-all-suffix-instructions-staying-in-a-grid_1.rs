impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let n = n as usize;
        let mut x = start_pos[0] as usize;
        let mut y = start_pos[1] as usize;
        let mut res = vec![0; s.len()];
        let mut max = s.len();
        for i in 0..s.len() {
            let c = s.chars().nth(i).unwrap();
            match c {
                'L' => {
                    if y == 0 {
                        max = i;
                    } else {
                        y -= 1;
                    }
                }
                'R' => {
                    if y == n - 1 {
                        max = i;
                    } else {
                        y += 1;
                    }
                }
                'U' => {
                    if x == 0 {
                        max = i;
                    } else {
                        x -= 1;
                    }
                }
                'D' => {
                    if x == n - 1 {
                        max = i;
                    } else {
                        x += 1;
                    }
                }
                _ => {}
            }
            res[i] = max as i32;
        }
        res
    }
}