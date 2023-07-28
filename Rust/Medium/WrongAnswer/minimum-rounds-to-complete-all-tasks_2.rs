impl Solution {
    pub fn minimum_rounds(tasks: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 10];
        for t in tasks {
            let mut idx = 0;
            while t > (1 << idx) {
                idx += 1;
            }
            cnt[idx] += 1;
        }
        let mut res = 0;
        let mut rem = 0;
        for i in 0..10 {
            let cur = (cnt[i] + rem + 1) / 2;
            rem = cnt[i] - cur * 2;
            res += cur;
        }
        res
    }
}