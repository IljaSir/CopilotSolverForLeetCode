impl Solution {
    pub fn valid_square(p1: Vec<i32>, p2: Vec<i32>, p3: Vec<i32>, p4: Vec<i32>) -> bool {
        

        let mut points = vec![p1, p2, p3, p4];
        points.sort();
        let mut dist = vec![];
        for i in 0..3 {
            for j in i+1..4 {
                dist.push((points[i][0] - points[j][0]).pow(2) + (points[i][1] - points[j][1]).pow(2));
            }
        }
        dist.sort();
        dist[0] != 0 && dist[0] == dist[3] && dist[4] == dist[5]
    }
}