impl Solution {
    pub fn triangle_number(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        for i in 0..nums.len() {
            let mut k = i + 2;
            for j in i+1..nums.len() {
                while k < nums.len() && nums[i] + nums[j] > nums[k] {
                    k += 1;
                }
                res += k - j - 1;
            }
        }
        res as i32
    }
}