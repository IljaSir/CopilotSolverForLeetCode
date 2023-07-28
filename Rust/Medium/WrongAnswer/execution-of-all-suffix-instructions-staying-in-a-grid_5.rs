impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut cur = start_pos.clone();
        let mut cnt = 0;
        let mut i = 0;
        for c in s.chars() {
            match c {
                'L' => {
                    if cur[1] > 0 {
                        cur[1] -= 1;
                        cnt += 1;
                    }
                }
                'R' => {
                    if cur[1] < n - 1 {
                        cur[1] += 1;
                        cnt += 1;
                    }
                }
                'U' => {
                    if cur[0] > 0 {
                        cur[0] -= 1;
                        cnt += 1;
                    }
                }
                'D' => {
                    if cur[0] < n - 1 {
                        cur[0] += 1;
                        cnt += 1;
                    }
                }
                _ => {}
            }
            res[i] = cnt;
            i += 1;
        }
        cur = start_pos.clone();
        cnt = 0;
        i = s.len() - 1;
        for c in s.chars().rev() {
            match c {
                'L' => {
                    if cur[1] < n - 1 {
                        cur[1] += 1;
                        cnt += 1;
                    }
                }
                'R' => {
                    if cur[1] > 0 {
                        cur[1] -= 1;
                        cnt += 1;
                    }
                }
                'U' => {
                    if cur[0] < n - 1 {
                        cur[0] += 1;
                        cnt += 1;
                    }
                }
                'D' => {
                    if cur[0] > 0 {
                        cur[0] -= 1;
                        cnt += 1;
                    }
                }
                _ => {}
            }
            res[i] = std::cmp::max(res[i], cnt);
            i -= 1;
        }
        res
    }
}