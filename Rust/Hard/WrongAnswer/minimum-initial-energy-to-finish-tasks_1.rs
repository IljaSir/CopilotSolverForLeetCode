impl Solution {
    pub fn minimum_effort(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = tasks;
        tasks.sort_by(|a, b| b[1].cmp(&a[1]));
        let mut energy = 0;
        for task in tasks {
            energy = std::cmp::max(energy + task[0], task[1]);
        }
        energy
    }
}