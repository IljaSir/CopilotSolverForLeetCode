impl Solution {
    pub fn minimum_finish_time(tires: Vec<Vec<i32>>, change_time: i32, num_laps: i32) -> i32 {
        
        let mut tires = tires;
        tires.sort_by_key(|x| x[0] * x[1]);
        let mut ans = i32::MAX;
        let mut sum = 0;
        let mut prev = 0;
        for tire in tires {
            let mut t = 0;
            let mut cur = 0;
            for i in 0..num_laps {
                cur += tire[0] * tire[1].pow(i);
                t += tire[0];
                if i > 0 {
                    t += change_time;
                }
                ans = ans.min(sum + cur + (num_laps - i - 1) * prev);
            }
            sum += t;
            prev = cur;
        }
        ans
    }
}