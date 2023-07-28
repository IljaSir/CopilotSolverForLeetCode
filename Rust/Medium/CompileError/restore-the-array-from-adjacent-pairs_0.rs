impl Solution {
    pub fn restore_array(adjacent_pairs: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for pair in adjacent_pairs {
            map.entry(pair[0]).or_insert(vec![]).push(pair[1]);
            map.entry(pair[1]).or_insert(vec![]).push(pair[0]);
        }
        let mut res = vec![];
        for (k, v) in map.iter() {
            if v.len() == 1 {
                res.push(*k);
                break;
            }
        }
        let mut prev = res[0];
        while res.len() < adjacent_pairs.len() + 1 {
            let next = map.get(&prev).unwrap();
            let next = if next[0] == res[res.len() - 2] {
                next[1]
            } else {
                next[0]
            };
            res.push(next);
            prev = next;
        }
        res
    }
}