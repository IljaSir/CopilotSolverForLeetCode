impl Solution {
    pub fn minimum_time_required(jobs: Vec<i32>, k: i32) -> i32 {
        
        let mut jobs = jobs;
        jobs.sort();
        let k = k as usize;
        let mut ans = std::i32::MAX;
        let mut workers = vec![0; k];
        let mut used = vec![false; k];
        let mut dfs = |jobs: &mut Vec<i32>, workers: &mut Vec<i32>, used: &mut Vec<bool>, idx: usize, max: &mut i32| {
            if idx == jobs.len() {
                *max = std::cmp::min(*max, workers.iter().max().unwrap().clone());
                return;
            }
            let mut seen = std::collections::HashSet::new();
            for i in 0..k {
                if used[i] || seen.contains(&workers[i]) {
                    continue;
                }
                seen.insert(workers[i]);
                used[i] = true;
                workers[i] += jobs[idx];
                dfs(jobs, workers, used, idx + 1, max);
                workers[i] -= jobs[idx];
                used[i] = false;
            }
        };
        dfs(&mut jobs, &mut workers, &mut used, 0, &mut ans);
        ans
    }
}