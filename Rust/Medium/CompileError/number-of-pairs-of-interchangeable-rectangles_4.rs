impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        let mut m = std::collections::HashMap::new();
        let mut cnt = 0;
        for r in rectangles {
            let k = r[0] as f64 / r[1] as f64;
            if let Some(n) = m.get_mut(&k) {
                cnt += *n;
                *n += 1;
            } else {
                m.insert(k, 1);
            }
        }
        cnt
    }
}