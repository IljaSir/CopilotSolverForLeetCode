impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut m = n;
        let mut s = std::collections::HashSet::new();
        while m != 1 {
            if s.contains(&m) {
                return false;
            }
            s.insert(m);
            let mut t = 0;
            while m > 0 {
                let d = m % 10;
                t += d * d;
                m /= 10;
            }
            m = t;
        }
        true
    }
}