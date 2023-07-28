impl Solution {
    pub fn least_bricks(wall: Vec<Vec<i32>>) -> i32 {
        

        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for row in wall {
            let mut sum = 0;
            for i in 0..row.len()-1 {
                sum += row[i];
                *map.entry(sum).or_insert(0) += 1;
                count = count.max(*map.get(&sum).unwrap());
            }
        }
        (wall.len() as i32) - count
    }
}