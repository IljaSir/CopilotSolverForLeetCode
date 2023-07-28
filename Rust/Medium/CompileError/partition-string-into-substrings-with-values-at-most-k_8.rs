impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut c = 0;
        let mut m = 0;
        for i in 0..s.len() {
            let d = s.as_bytes()[i] - b'0';
            m = m.max(d);
            if m * (i as i32 + 1) - c > k {
                c += m;
                m = 0;
            }
        }
        if m * (s.len() as i32) - c > k {
            -1
        } else {
            (s.len() as i32 + m - c + k - 1) / k
        }
    }
}