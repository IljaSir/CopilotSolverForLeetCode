impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![-1; rains.len()];
        let mut lake = std::collections::HashMap::new();
        let mut dry = std::collections::BinaryHeap::new();
        for (i, &r) in rains.iter().enumerate() {
            if r > 0 {
                if let Some(&prev) = lake.get(&r) {
                    if let Some(&d) = dry.peek() {
                        if d < prev {
                            return vec![];
                        }
                        ans[dry.pop().unwrap()] = r;
                    } else {
                        return vec![];
                    }
                }
                lake.insert(r, i);
                ans[i] = -1;
            } else {
                dry.push(i);
            }
        }
        ans
    }
}