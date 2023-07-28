impl Solution {
    pub fn restore_array(adjacent_pairs: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut adj = std::collections::HashMap::new();
        for pair in adjacent_pairs {
            adj.entry(pair[0]).or_insert_with(Vec::new).push(pair[1]);
            adj.entry(pair[1]).or_insert_with(Vec::new).push(pair[0]);
        }
        let mut ans = Vec::new();
        let mut start = *adj.iter().find(|(_, v)| v.len() == 1).unwrap().0;
        ans.push(start);
        loop {
            let next = adj.get_mut(&start).unwrap().pop().unwrap();
            ans.push(next);
            if adj.get(&next).unwrap().len() == 1 {
                break;
            }
            start = next;
        }
        ans
    }
}