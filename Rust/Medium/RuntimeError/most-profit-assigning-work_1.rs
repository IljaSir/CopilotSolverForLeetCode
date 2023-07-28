impl Solution {
    pub fn max_profit_assignment(difficulty: Vec<i32>, profit: Vec<i32>, worker: Vec<i32>) -> i32 {
        
        let mut jobs = difficulty
            .into_iter()
            .zip(profit.into_iter())
            .collect::<Vec<_>>();
        jobs.sort_by(|a, b| a.0.cmp(&b.0));
        let mut max = 0;
        let mut max_profit = 0;
        for i in 0..jobs.len() {
            if jobs[i].1 > max_profit {
                max_profit = jobs[i].1;
            }
            jobs[i].1 = max_profit;
        }
        let mut res = 0;
        for w in worker {
            if w >= jobs[jobs.len() - 1].0 {
                res += jobs[jobs.len() - 1].1;
            } else {
                let mut l = 0;
                let mut r = jobs.len() - 1;
                while l < r {
                    let mid = (l + r) / 2;
                    if jobs[mid].0 > w {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                res += jobs[l - 1].1;
            }
        }
        res
    }
}