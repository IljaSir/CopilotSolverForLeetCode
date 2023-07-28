impl Solution {
    pub fn count_points(points: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = vec![];
        for query in queries {
            let mut count = 0;
            for point in points.iter() {
                if (point[0] - query[0]).pow(2) + (point[1] - query[1]).pow(2) <= query[2].pow(2) {
                    count += 1;
                }
            }
            result.push(count);
        }
        result
    }
}