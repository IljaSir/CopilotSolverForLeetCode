impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let sum: i32 = nums.iter().sum();
        let target = sum % p;
        if target == 0 {
            return 0;
        }
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        let mut cur_sum = 0;
        let mut min = nums.len();
        for i in 0..nums.len() {
            cur_sum = (cur_sum + nums[i]) % p;
            map.insert(cur_sum, i as i32);
            let need = (cur_sum - target + p) % p;
            if let Some(&j) = map.get(&need) {
                if i as i32 - j < min as i32 {
                    min = i - j as usize;
                }
            }
        }
        if min == nums.len() { -1 } else { min as i32 }
    }
}