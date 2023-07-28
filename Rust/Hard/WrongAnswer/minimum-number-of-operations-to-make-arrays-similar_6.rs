impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut diff = vec![0; nums.len()];
        for i in 0..nums.len() {
            diff[i] = nums[i] - target[i];
        }
        let mut odd = 0;
        let mut even = 0;
        for i in 0..diff.len() {
            if i % 2 == 0 {
                even += diff[i];
            } else {
                odd += diff[i];
            }
        }
        if even != odd {
            return -1;
        }
        let mut ans = 0;
        for i in 0..diff.len() {
            if diff[i] != 0 {
                ans += 1;
                let mut j = i + 1;
                while j < diff.len() && diff[j] == 0 {
                    j += 1;
                }
                diff[j] += diff[i];
            }
        }
        ans
    }
}