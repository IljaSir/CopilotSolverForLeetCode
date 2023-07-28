impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let (a, b) = (event1[0].clone(), event1[1].clone());
        let (c, d) = (event2[0].clone(), event2[1].clone());
        let (a, b) = (a.as_bytes(), b.as_bytes());
        let (c, d) = (c.as_bytes(), d.as_bytes());
        let (a, b) = (a[0] * 60 + a[1], b[0] * 60 + b[1]);
        let (c, d) = (c[0] * 60 + c[1], d[0] * 60 + d[1]);
        let (a, b) = (a as i32, b as i32);
        let (c, d) = (c as i32, d as i32);
        if a <= c && c <= b {
            return true;
        }
        if a <= d && d <= b {
            return true;
        }
        if c <= a && a <= d {
            return true;
        }
        if c <= b && b <= d {
            return true;
        }
        false
    }
}