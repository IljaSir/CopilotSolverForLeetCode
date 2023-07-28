impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            sum += nums[i];
            if sum == 0 || (map.contains_key(&sum) && i - map.get(&sum).unwrap() > 1) {
                return true;
            } else if !map.contains_key(&sum) {
                map.insert(sum, i);
            }
        }
        false
    }
}