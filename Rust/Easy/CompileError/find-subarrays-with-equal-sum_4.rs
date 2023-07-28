impl Solution {
    pub fn find_subarrays(nums: Vec<i32>) -> bool {
        
        let mut sum: i32 = 0;
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for i in 0..nums.len() {
            sum += nums[i];
            if map.contains_key(&sum) {
                if i - map[&sum] > 1 {
                    return true;
                }
            } else {
                map.insert(sum, i as i32);
            }
        }
        false
    }
}