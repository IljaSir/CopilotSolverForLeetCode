impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut s = start.chars();
        let mut t = target.chars();
        let mut s0 = s.next().unwrap();
        let mut t0 = t.next().unwrap();
        while let Some(s1) = s.next() {
            let t1 = t.next().unwrap();
            if s0 == 'L' && t0 == 'R' && s1 == 'R' && t1 == 'L' {
                return false;
            }
            s0 = s1;
            t0 = t1;
        }
        true
    }
}