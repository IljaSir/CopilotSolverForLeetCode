impl Solution {
    pub fn count_points(points: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        for query in queries {
            let mut count = 0;
            for point in &points {
                if (point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2] {
                    count += 1;
                }
            }
            res.push(count);
        }
        res
    }
}