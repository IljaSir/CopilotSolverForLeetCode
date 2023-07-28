impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut result = -1;
        for i in 0..nums.len() {
            sum += nums[i];
            map.insert(sum, i as i32);
        }
        if sum < x {
            return -1;
        }
        if sum == x {
            return nums.len() as i32;
        }
        sum = 0;
        for i in (0..nums.len()).rev() {
            sum += nums[i];
            if sum == x {
                result = i as i32;
                break;
            }
            if let Some(&j) = map.get(&(x - sum)) {
                if j < i as i32 {
                    result = (i as i32 - j) as i32;
                    break;
                }
            }
        }
        if result == -1 {
            return result;
        }
        result += (nums.len() - result as usize) as i32;
        result as i32
    }
}