impl Solution {
    pub fn minimum_time_required(jobs: Vec<i32>, k: i32) -> i32 {
        
        let mut jobs = jobs;
        jobs.sort();
        let mut left = jobs[0];
        let mut right = jobs.iter().sum();
        while left < right {
            let mid = left + (right - left) / 2;
            if Solution::check(&jobs, k, mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
    fn check(jobs: &Vec<i32>, k: i32, limit: i32) -> bool {
        let mut workloads = vec![0; k as usize];
        Solution::backtrack(jobs, &mut workloads, 0, limit)
    }
    fn backtrack(jobs: &Vec<i32>, workloads: &mut Vec<i32>, i: usize, limit: i32) -> bool {
        if i >= jobs.len() {
            return true;
        }
        let cur = jobs[i];
        for j in 0..workloads.len() {
            if workloads[j] + cur <= limit {
                workloads[j] += cur;
                if Solution::backtrack(jobs, workloads, i + 1, limit) {
                    return true;
                }
                workloads[j] -= cur;
            }
            if workloads[j] == 0 || workloads[j] + cur == limit {
                break;
            }
        }
        false
    }
}