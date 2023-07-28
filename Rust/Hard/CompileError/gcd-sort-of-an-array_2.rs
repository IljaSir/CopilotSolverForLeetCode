impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let mut g = nums[0];
        for i in 1..nums.len() {
            g = gcd(g, nums[i]);
        }
        if g == 1 {
            return false;
        }
        nums.sort();
        for i in 1..nums.len() {
            if gcd(nums[i-1], nums[i]) == 1 {
                return false;
            }
        }
        return true;
    }
}