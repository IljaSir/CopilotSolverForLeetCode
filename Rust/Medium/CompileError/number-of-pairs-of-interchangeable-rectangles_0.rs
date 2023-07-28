impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        let mut map = std::collections::HashMap::new();
        for r in rectangles {
            let ratio = r[0] as f64 / r[1] as f64;
            *map.entry(ratio).or_insert(0) += 1;
        }
        let mut count = 0;
        for (_, v) in map {
            count += v * (v - 1) / 2;
        }
        count
    }
}