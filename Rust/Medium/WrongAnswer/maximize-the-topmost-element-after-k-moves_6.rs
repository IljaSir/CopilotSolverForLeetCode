impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut k = k;
        let mut res = -1;
        let n = nums.len();
        for i in 0..n {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            let x = nums[i];
            let mut cnt = 0;
            for j in 0..n {
                if nums[j] == x {
                    cnt += 1;
                }
            }
            let y = n - i;
            let z = (k as usize) / y;
            if z < cnt {
                res = x + (k as i32) / (n - i) as i32;
                break;
            }
            k -= (cnt * (n - i)) as i32;
        }
        if res == -1 && k > 0 {
            res = nums[n - 1] + k / n as i32;
        }
        res
    }
}