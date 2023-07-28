impl Solution {
    pub fn num_of_minutes(n: i32, head_id: i32, manager: Vec<i32>, inform_time: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for (i, &m) in manager.iter().enumerate() {
            if m == -1 {
                continue;
            }
            let key = m as usize;
            if let Some(v) = map.get_mut(&key) {
                v.push(i as i32);
            } else {
                map.insert(key, vec![i as i32]);
            }
        }
        let mut max = 0;
        let mut stack = vec![(head_id, 0)];
        while !stack.is_empty() {
            let (id, t) = stack.pop().unwrap();
            let id = id as usize;
            if let Some(v) = map.get(&id) {
                for &i in v {
                    stack.push((i, t + inform_time[id]));
                }
            } else {
                max = std::cmp::max(max, t + inform_time[id]);
            }
        }
        max
    }
}