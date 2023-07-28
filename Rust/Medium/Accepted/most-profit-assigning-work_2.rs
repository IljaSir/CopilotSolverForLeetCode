impl Solution {
    pub fn max_profit_assignment(difficulty: Vec<i32>, profit: Vec<i32>, worker: Vec<i32>) -> i32 {
        
        let mut jobs = difficulty.into_iter().zip(profit.into_iter()).collect::<Vec<_>>();
        jobs.sort_by_key(|x| x.0);
        let mut max = 0;
        for (_, p) in jobs.iter_mut() {
            if *p < max {
                *p = max;
            } else {
                max = *p;
            }
        }
        let mut res = 0;
        for w in worker {
            let mut l = 0;
            let mut r = jobs.len();
            while l < r {
                let m = (l + r) / 2;
                if jobs[m].0 <= w {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if l > 0 {
                res += jobs[l-1].1;
            }
        }
        res
    }
}