impl Solution {
    pub fn max_task_assign(tasks: Vec<i32>, workers: Vec<i32>, pills: i32, strength: i32) -> i32 {
        
        let mut tasks = tasks;
        let mut workers = workers;
        tasks.sort();
        workers.sort();
        let mut l = 0;
        let mut r = tasks.len();
        while l < r {
            let m = l + (r - l + 1) / 2;
            if Solution::can_assign(&tasks, &workers, pills, strength, m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
    fn can_assign(tasks: &Vec<i32>, workers: &Vec<i32>, pills: i32, strength: i32, k: usize) -> bool {
        let mut i = 0;
        let mut j = 0;
        let mut p = pills;
        while i < k {
            if workers[j] + p * strength >= tasks[i] {
                i += 1;
            }
            j += 1;
            if j == workers.len() {
                if p > 0 {
                    p -= 1;
                    j = 0;
                } else {
                    break;
                }
            }
        }
        i == k
    }
}