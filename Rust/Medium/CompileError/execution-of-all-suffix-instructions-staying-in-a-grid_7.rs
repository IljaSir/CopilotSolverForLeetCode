impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut pos = start_pos;
        let mut i = 0;
        let mut j = 0;
        let mut last = 0;
        let mut c = 0;
        while i < s.len() {
            let d = match s.chars().nth(i).unwrap() {
                'L' => {
                    if pos[1] == 0 {
                        last = i;
                    } else {
                        pos[1] -= 1;
                    }
                    1
                }
                'R' => {
                    if pos[1] == n - 1 {
                        last = i;
                    } else {
                        pos[1] += 1;
                    }
                    1
                }
                'U' => {
                    if pos[0] == 0 {
                        last = i;
                    } else {
                        pos[0] -= 1;
                    }
                    1
                }
                'D' => {
                    if pos[0] == n - 1 {
                        last = i;
                    } else {
                        pos[0] += 1;
                    }
                    1
                }
                _ => 0,
            };
            res[j] += d;
            c += d;
            if i == last {
                j += 1;
                c = 0;
                pos = start_pos.clone();
            }
            i += 1;
        }
        res
    }
}