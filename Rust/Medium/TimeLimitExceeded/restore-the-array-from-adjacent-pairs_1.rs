impl Solution {
    pub fn restore_array(adjacent_pairs: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for pair in adjacent_pairs {
            map.entry(pair[0]).or_insert_with(Vec::new).push(pair[1]);
            map.entry(pair[1]).or_insert_with(Vec::new).push(pair[0]);
        }
        let mut res = Vec::new();
        let mut prev = None;
        let mut start = 0;
        for (k, v) in map.iter() {
            if v.len() == 1 {
                start = *k;
                break;
            }
        }
        res.push(start);
        while let Some(v) = map.get_mut(&start) {
            if let Some(p) = prev {
                if v[0] == p {
                    start = v[1];
                } else {
                    start = v[0];
                }
            } else {
                start = v[0];
            }
            res.push(start);
            prev = Some(start);
        }
        res
    }
}