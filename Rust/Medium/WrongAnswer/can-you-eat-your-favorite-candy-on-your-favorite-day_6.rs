impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut pre = vec![0];
        for i in candies_count {
            pre.push(pre.last().unwrap() + i);
        }
        let mut res = vec![];
        for q in queries {
            let tp = q[0];
            let day = q[1];
            let cap = q[2];
            let min = pre[tp as usize];
            let max = pre[tp as usize + 1] - 1;
            if min > day * cap || max < day {
                res.push(false);
            } else {
                res.push(true);
            }
        }
        res
    }
}