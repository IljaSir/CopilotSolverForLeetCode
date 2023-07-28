impl Solution {
    pub fn least_bricks(wall: Vec<Vec<i32>>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        for row in wall {
            let mut sum = 0;
            for &x in row.iter().take(row.len() - 1) {
                sum += x;
                *map.entry(sum).or_insert(0) += 1;
                max = max.max(*map.get(&sum).unwrap());
            }
        }
        (wall.len() as i32) - max
    }
}