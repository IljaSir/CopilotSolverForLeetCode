impl Solution {
    pub fn least_bricks(wall: Vec<Vec<i32>>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for row in wall {
            let mut sum = 0;
            for i in 0..row.len() - 1 {
                sum += row[i];
                *map.entry(sum).or_insert(0) += 1;
            }
        }
        let mut max = 0;
        for (_, v) in map {
            max = max.max(v);
        }
        wall.len() as i32 - max
    }
}