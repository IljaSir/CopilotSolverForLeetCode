impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut diff = vec![0; nums.len()];
        for i in 0..nums.len() {
            diff[i] = nums[i] - target[i];
        }
        diff.sort();
        let mut ans = 0;
        let mut i = 0;
        let mut j = diff.len() - 1;
        while i < j {
            ans += diff[j] - diff[i];
            i += 1;
            j -= 1;
        }
        ans
    }
}