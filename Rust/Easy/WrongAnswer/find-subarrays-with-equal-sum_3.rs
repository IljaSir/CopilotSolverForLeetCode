impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if i > 0 && sum == 0 {
                return true;
            }
            if map.contains_key(&sum) {
                return true;
            } else {
                map.insert(sum, i);
            }
        }
        false
    }
}