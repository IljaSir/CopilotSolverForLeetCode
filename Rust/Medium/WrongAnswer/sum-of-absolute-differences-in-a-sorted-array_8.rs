impl Solution {
    pub fn get_sum_absolute_differences(nums: Vec<i32>) -> Vec<i32> {
        
        let mut s = 0;
        let mut v = Vec::new();
        for i in 0..nums.len() {
            s += nums[i];
            v.push(s);
        }
        let mut ret = Vec::new();
        for i in 0..nums.len() {
            let left = i as i32 * nums[i] - v[i];
            let right = v[v.len() - 1] - v[i] - (nums.len() as i32 - i as i32 - 1) * nums[i];
            ret.push(left + right);
        }
        ret
    }
}