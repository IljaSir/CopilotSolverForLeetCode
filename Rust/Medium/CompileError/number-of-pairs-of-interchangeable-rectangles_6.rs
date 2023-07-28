impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        let mut m: std::collections::HashMap<(i32, i32), i64> = std::collections::HashMap::new();
        let mut count = 0;
        for r in rectangles.iter() {
            let g = gcd(r[0], r[1]);
            let key = (r[0]/g, r[1]/g);
            let v = m.entry(key).or_default();
            count += *v;
            *v += 1;
        }
        count
    }
}