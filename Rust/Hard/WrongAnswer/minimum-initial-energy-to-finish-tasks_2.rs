impl Solution {
    pub fn minimum_effort(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = tasks;
        tasks.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut ans = 0;
        let mut energy = 0;
        for task in tasks {
            if energy < task[1] {
                ans += task[1] - energy;
                energy = task[1];
            }
            energy -= task[0];
        }
        ans
    }
}