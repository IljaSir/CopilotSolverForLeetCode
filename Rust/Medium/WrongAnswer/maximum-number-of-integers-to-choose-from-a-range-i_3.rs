impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut banned = banned;
        banned.sort();
        let mut l = 0;
        let mut r = 0;
        let mut res = 0;
        let mut sum = 0;
        while r < banned.len() {
            if banned[r] - 1 - l > 0 {
                let tmp = banned[r] - 1 - l;
                let mut sum_tmp = tmp * (tmp + 1) / 2;
                if sum + sum_tmp > max_sum {
                    sum_tmp = max_sum - sum;
                }
                res += sum_tmp / (banned[r] - 1 - l);
                sum += sum_tmp;
                if sum >= max_sum {
                    break;
                }
            }
            l = banned[r] + 1;
            r += 1;
        }
        if r == banned.len() {
            let tmp = n - l + 1;
            let mut sum_tmp = tmp * (tmp + 1) / 2;
            if sum + sum_tmp > max_sum {
                sum_tmp = max_sum - sum;
            }
            res += sum_tmp / (n - l + 1);
        }
        res
    }
}