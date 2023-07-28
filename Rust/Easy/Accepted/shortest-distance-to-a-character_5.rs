impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut ret = Vec::new();
        let mut prev = -1;
        for i in 0..s.len() {
            if s.as_bytes()[i] == c as u8 {
                ret.push(0);
                prev = i as i32;
            } else {
                if prev == -1 {
                    ret.push(s.len() as i32);
                } else {
                    ret.push((i as i32 - prev).abs());
                }
            }
        }
        prev = -1;
        for i in (0..s.len()).rev() {
            if s.as_bytes()[i] == c as u8 {
                prev = i as i32;
            } else {
                if prev != -1 {
                    ret[i] = std::cmp::min(ret[i], (i as i32 - prev).abs());
                }
            }
        }
        ret
    }
}