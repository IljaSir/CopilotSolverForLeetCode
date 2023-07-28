impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s = s;
        let mut t = t;
        let mut s_iter = s.chars().rev();
        let mut t_iter = t.chars().rev();
        let mut s_pop = s_iter.next();
        let mut t_pop = t_iter.next();
        let mut s_count = 0;
        let mut t_count = 0;
        while s_pop.is_some() || t_pop.is_some() {
            if s_pop.is_some() {
                if s_pop.unwrap() == '#' {
                    s_count += 1;
                } else if s_count > 0 {
                    s_count -= 1;
                } else {
                    s_pop = None;
                    continue;
                }
                s_pop = s_iter.next();
            }
            if t_pop.is_some() {
                if t_pop.unwrap() == '#' {
                    t_count += 1;
                } else if t_count > 0 {
                    t_count -= 1;
                } else {
                    t_pop = None;
                    continue;
                }
                t_pop = t_iter.next();
            }
        }
        s_pop == t_pop
    }
}