impl Solution {
    pub fn number_of_boomerangs(points: Vec<Vec<i32>>) -> i32 {
        

        let mut res = 0;
        for i in 0..points.len() {
            let mut map = std::collections::HashMap::new();
            for j in 0..points.len() {
                if i == j {
                    continue;
                }
                let d = (points[i][0] - points[j][0]).pow(2) + (points[i][1] - points[j][1]).pow(2);
                *map.entry(d).or_insert(0) += 1;
            }
            for (_, v) in map.iter() {
                res += v * (v - 1);
            }
        }
        res
    }
}