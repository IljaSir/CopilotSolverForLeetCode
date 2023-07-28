impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        let mut max = 0;
        nums.sort();
        for i in 0..nums.len() {
            if nums[i] > max {
                let mut tmp = nums[i];
                for j in (i+1)..nums.len() {
                    if k > 0 {
                        tmp += 1;
                        k -= 1;
                    } else {
                        break;
                    }
                }
                if tmp > max {
                    max = tmp;
                }
            }
        }
        max
    }
}