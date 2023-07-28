impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        for i in 0..(1<<nums.len()){
            let mut j = i;
            let mut idx = 0;
            let mut ok = true;
            while j > 0 {
                if j & 1 > 0 {
                    for l in 0..idx {
                        if (j & (1<<l)) > 0 && (nums[l] - nums[idx]).abs() == k {
                            ok = false;
                            break;
                        }
                    }
                    if !ok {
                        break;
                    }
                }
                j >>= 1;
                idx += 1;
            }
            if ok {
                res += 1;
            }
        }
        res
    }
}