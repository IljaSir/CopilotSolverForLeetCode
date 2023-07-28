impl Solution {
    pub fn least_bricks(wall: Vec<Vec<i32>>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        for row in wall.iter() {
            let mut sum = 0;
            for i in 0..row.len()-1 {
                sum += row[i];
                *map.entry(sum).or_insert(0) += 1;
            }
        }
        let mut max = 0;
        for (_, v) in map.iter() {
            if *v > max {
                max = *v;
            }
        }
        (wall.len() - max) as i32
    }
}