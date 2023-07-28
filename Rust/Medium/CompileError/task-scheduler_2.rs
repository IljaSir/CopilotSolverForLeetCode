impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        

        let mut map: Vec<i32> = vec![0; 26];
        for c in tasks {
            map[c as usize - 'A' as usize] += 1;
        }
        map.sort();
        let max_val = map[25] - 1;
        let mut idle_slots = max_val * n;
        for i in (0..25).rev() {
            idle_slots -= map[i].min(max_val);
        }
        (tasks.len() as i32).max(idle_slots + tasks.len() as i32)
    }
}