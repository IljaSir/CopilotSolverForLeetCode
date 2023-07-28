impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        

        let mut counts = [0; 26];
        for &c in tasks.iter() {
            counts[(c as u8 - b'A') as usize] += 1;
        }
        counts.sort_unstable();
        let max_count = counts[25];
        let mut idle_time = (max_count - 1) * n;
        for i in (0..25).rev() {
            idle_time -= counts[i].min(max_count - 1);
        }
        (tasks.len() as i32).max(idle_time + tasks.len() as i32)
    }
}