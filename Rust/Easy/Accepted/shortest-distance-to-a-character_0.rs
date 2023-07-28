impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut pos = -1;
        for i in 0..s.len() {
            if s.as_bytes()[i] == c as u8 {
                pos = i as i32;
            }
            res[i] = if pos == -1 {
                s.len() as i32
            } else {
                i as i32 - pos
            };
        }
        pos = -1;
        for i in (0..s.len()).rev() {
            if s.as_bytes()[i] == c as u8 {
                pos = i as i32;
            }
            if pos != -1 {
                res[i] = res[i].min(pos - i as i32);
            }
        }
        res
    }
}