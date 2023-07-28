impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        let mut map = std::collections::HashMap::new();
        let mut result = 0;
        for rect in rectangles {
            let ratio = rect[0] as f64 / rect[1] as f64;
            let count = map.entry(ratio).or_insert(0);
            result += *count;
            *count += 1;
        }
        result
    }
}