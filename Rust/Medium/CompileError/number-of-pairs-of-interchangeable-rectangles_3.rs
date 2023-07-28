impl Solution {
    pub fn interchangeable_rectangles(rectangles: Vec<Vec<i32>>) -> i64 {
        
        use std::collections::HashMap;
        let mut map = HashMap::new();
        for r in rectangles {
            let x = r[0];
            let y = r[1];
            let g = gcd(x, y);
            let x = x / g;
            let y = y / g;
            *map.entry((x, y)).or_insert(0) += 1;
        }
        let mut ans = 0i64;
        for (_, v) in map.iter() {
            ans += v * (v - 1) / 2;
        }
        ans
    }
}