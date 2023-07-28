impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![-1; rains.len()];
        let mut lake = std::collections::HashMap::new();
        let mut dry = std::collections::BinaryHeap::new();
        for i in 0..rains.len() {
            if rains[i] > 0 {
                if lake.contains_key(&rains[i]) {
                    if dry.is_empty() {
                        return vec![];
                    }
                    let mut j = dry.pop().unwrap();
                    while j < i as i32 {
                        j = dry.pop().unwrap();
                    }
                    res[j as usize] = rains[i];
                }
                lake.insert(rains[i], i as i32);
                res[i] = -1;
            } else {
                dry.push(i as i32);
                res[i] = 1;
            }
        }
        res
    }
}