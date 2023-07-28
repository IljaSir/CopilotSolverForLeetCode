impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        use std::collections::HashMap;
        let mut map: HashMap<f64, i64> = HashMap::new();
        let mut count = 0;
        for rect in rectangles {
            let ratio = rect[0] as f64 / rect[1] as f64;
            if let Some(v) = map.get_mut(&ratio) {
                count += *v;
                *v += 1;
            } else {
                map.insert(ratio, 1);
            }
        }
        count
    }
}