impl Solution {
    pub fn minimum_effort(tasks: Vec<Vec<i32>>) -> i32 {
        
        let mut tasks = tasks;
        tasks.sort_unstable_by_key(|t| t[1] - t[0]);
        let mut ans = tasks.iter().map(|t| t[1]).sum::<i32>();
        let mut cur = ans;
        for t in tasks {
            cur -= t[0];
            ans = ans.min(cur);
        }
        ans
    }
}