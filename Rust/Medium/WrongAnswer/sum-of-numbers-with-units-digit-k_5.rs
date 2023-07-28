impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        if num == 0 {
            return 0;
        }
        if num < k {
            return -1;
        }
        let mut res = 0;
        let mut remain = num;
        while remain > 0 {
            if remain < k {
                res += 1;
                break;
            }
            remain -= k;
            res += 1;
        }
        res
    }
}