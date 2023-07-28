impl Solution {
    pub fn task_scheduler_ii(tasks: Vec<i32>, space: i32) -> i64 {
        
        let mut count = vec![0; 100001];
        let mut max = 0;
        for &task in tasks.iter() {
            count[task as usize] += 1;
            max = max.max(count[task as usize]);
        }
        let mut max_count = 0;
        for i in 0..count.len() {
            if count[i] == max {
                max_count += 1;
            }
        }
        let ans = (max - 1) * (space + 1) + max_count;
        ans.max(tasks.len()) as i64
    }
}