impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        

        let mut map = vec![0; 26];
        for t in tasks {
            map[t as usize - 'A' as usize] += 1;
        }
        map.sort();
        let max_val = map[25] - 1;
        let idle_slots = max_val * n;
        let mut idle = idle_slots;
        for i in 0..25 {
            idle -= std::cmp::min(map[i], max_val);
        }
        if idle > 0 {
            idle + tasks.len() as i32
        } else {
            tasks.len() as i32
        }
    }
}