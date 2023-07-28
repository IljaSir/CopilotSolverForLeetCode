impl Solution {
    pub fn count_points(points: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for q in queries {
            let mut count = 0;
            for p in &points {
                if (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]) <= q[2] * q[2] {
                    count += 1;
                }
            }
            result.push(count);
        }
        result
    }
}