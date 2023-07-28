impl Solution {
    pub fn number_of_boomerangs(points: Vec<Vec<i32>>) -> i32 {
        

        let mut res = 0;
        for i in 0..points.len() {
            let mut map = std::collections::HashMap::new();
            for j in 0..points.len() {
                if i == j { continue; }
                let dist = (points[i][0] - points[j][0]).pow(2) + (points[i][1] - points[j][1]).pow(2);
                let count = map.entry(dist).or_insert(0);
                *count += 1;
            }
            for (_, count) in map {
                if count > 1 {
                    res += count * (count - 1);
                }
            }
        }
        res
    }
}