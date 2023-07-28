impl Solution {
    pub fn least_bricks(wall: Vec<Vec<i32>>) -> i32 {
        

        let mut count: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        let mut max = 0;
        for row in &wall {
            let mut sum = 0;
            for i in 0..row.len()-1 {
                sum += row[i];
                let c = count.entry(sum).or_insert(0);
                *c += 1;
                if *c > max {
                    max = *c;
                }
            }
        }
        wall.len() as i32 - max
    }
}