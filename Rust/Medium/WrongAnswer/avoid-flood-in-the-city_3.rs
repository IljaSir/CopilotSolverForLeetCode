impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut ret = vec![-1; rains.len()];
        let mut lakes = std::collections::HashMap::new();
        let mut dry = std::collections::BinaryHeap::new();
        for (i, &r) in rains.iter().enumerate() {
            if r == 0 {
                dry.push(std::cmp::Reverse(i));
            } else {
                ret[i] = -1;
                if let Some(&p) = lakes.get(&r) {
                    if let Some(std::cmp::Reverse(j)) = dry.pop() {
                        if j < p {
                            return Vec::new();
                        }
                        ret[j] = r;
                    } else {
                        return Vec::new();
                    }
                }
                lakes.insert(r, i);
            }
        }
        for i in dry {
            ret[i.0] = 1;
        }
        ret
    }
}