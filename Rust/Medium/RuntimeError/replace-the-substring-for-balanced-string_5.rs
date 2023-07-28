impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut map = [0; 4];
        let mut res = s.len() as i32;
        for c in s.chars() {
            match c {
                'Q' => map[0] += 1,
                'W' => map[1] += 1,
                'E' => map[2] += 1,
                'R' => map[3] += 1,
                _ => (),
            }
        }
        let mut i = 0;
        let mut j = 0;
        let mut n = map[0] - s.len() / 4;
        while j < s.len() {
            if n > 0 {
                match s.chars().nth(j).unwrap() {
                    'Q' => n -= 1,
                    'W' => map[1] -= 1,
                    'E' => map[2] -= 1,
                    'R' => map[3] -= 1,
                    _ => (),
                }
                j += 1;
            } else {
                res = res.min(j as i32 - i as i32);
                match s.chars().nth(i).unwrap() {
                    'Q' => n += 1,
                    'W' => map[1] += 1,
                    'E' => map[2] += 1,
                    'R' => map[3] += 1,
                    _ => (),
                }
                i += 1;
            }
        }
        res
    }
}