impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let mut s = start.chars();
        let mut e = end.chars();
        let mut s_l = 0;
        let mut e_l = 0;
        let mut s_r = 0;
        let mut e_r = 0;
        loop {
            let s_c = s.next();
            let e_c = e.next();
            match (s_c, e_c) {
                (Some('L'), Some('L')) => {
                    s_l += 1;
                    e_l += 1;
                },
                (Some('R'), Some('R')) => {
                    s_r += 1;
                    e_r += 1;
                },
                (Some('X'), Some('X')) => (),
                (Some('L'), Some('X')) => {
                    s_l += 1;
                },
                (Some('X'), Some('L')) => {
                    e_l += 1;
                },
                (Some('R'), Some('X')) => {
                    s_r += 1;
                },
                (Some('X'), Some('R')) => {
                    e_r += 1;
                },
                _ => return false,
            }
            if s_l > e_l || s_r > e_r {
                return false;
            }
            if s_c.is_none() && e_c.is_none() {
                return true;
            }
        }
    }
}