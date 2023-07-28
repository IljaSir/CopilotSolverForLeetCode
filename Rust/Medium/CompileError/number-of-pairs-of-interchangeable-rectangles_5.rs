impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        for r in rectangles {
            let k = (r[0] as f64 / r[1] as f64) as f64;
            let v = map.entry(k).or_insert(0);
            count += *v;
            *v += 1;
        }
        count
    }
}