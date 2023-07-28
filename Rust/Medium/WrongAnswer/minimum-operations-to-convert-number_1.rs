impl Solution {
    pub fn minimum_operations(nums: Vec<i32>, start: i32, goal: i32) -> i32 {
        
        let mut sum = 0;
        for n in nums {
            sum += n;
        }
        let mut res = 0;
        let mut cur = start;
        let mut bits = 0;
        while bits < 31 {
            let bit = 1 << bits;
            if (goal & bit) != (cur & bit) {
                if (goal & bit) != 0 {
                    if (sum & bit) == 0 {
                        return -1;
                    }
                    cur |= bit;
                } else {
                    if (sum & bit) != 0 {
                        return -1;
                    }
                    cur &= !bit;
                }
                res += 1;
            }
            bits += 1;
        }
        res
    }
}