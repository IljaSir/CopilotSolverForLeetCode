impl Solution {
    pub fn count_points(points: Vec<Vec<i32>>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        for q in queries {
            let mut count = 0;
            for p in &points {
                let d = (p[0] - q[0]).pow(2) + (p[1] - q[1]).pow(2);
                if d <= q[2].pow(2) {
                    count += 1;
                }
            }
            res.push(count);
        }
        res
    }
}