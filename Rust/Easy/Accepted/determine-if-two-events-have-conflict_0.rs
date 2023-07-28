impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let (s1, e1) = (event1[0].clone(), event1[1].clone());
        let (s2, e2) = (event2[0].clone(), event2[1].clone());
        let (h1, m1) = (s1[0..2].parse::<u32>().unwrap(), s1[3..5].parse::<u32>().unwrap());
        let (h2, m2) = (s2[0..2].parse::<u32>().unwrap(), s2[3..5].parse::<u32>().unwrap());
        let (h3, m3) = (e1[0..2].parse::<u32>().unwrap(), e1[3..5].parse::<u32>().unwrap());
        let (h4, m4) = (e2[0..2].parse::<u32>().unwrap(), e2[3..5].parse::<u32>().unwrap());
        let t1 = h1 * 60 + m1;
        let t2 = h2 * 60 + m2;
        let t3 = h3 * 60 + m3;
        let t4 = h4 * 60 + m4;
        if t1 > t4 || t3 < t2 {
            false
        } else {
            true
        }
    }
}