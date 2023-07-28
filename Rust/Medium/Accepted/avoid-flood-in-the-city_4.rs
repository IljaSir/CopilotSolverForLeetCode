impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut dry = vec![];
        let mut res = vec![-1; rains.len()];
        let mut lakes = std::collections::BTreeMap::new();
        for (i, &x) in rains.iter().enumerate() {
            if x > 0 {
                if let Some(&p) = lakes.get(&x) {
                    if let Some(&j) = dry.iter().find(|&&j| j > p) {
                        res[j] = x;
                        dry.remove(dry.iter().position(|&y| y == j).unwrap());
                    } else {
                        return vec![];
                    }
                }
                res[i] = -1;
                lakes.insert(x, i);
            } else {
                dry.push(i);
            }
        }
        for &i in dry.iter() {
            res[i] = 1;
        }
        res
    }
}