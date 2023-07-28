impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let k = k as usize;
        if nums.len() % k != 0 {
            return false;
        }
        let mut nums = nums;
        nums.sort();
        let mut map = std::collections::HashMap::new();
        for &n in nums.iter() {
            *map.entry(n).or_insert(0) += 1;
        }
        for i in 0..nums.len() {
            if nums[i] == -1 {
                continue;
            }
            let mut num = nums[i];
            for j in 0..k {
                if let Some(v) = map.get_mut(&(num + j as i32)) {
                    if *v == 0 {
                        return false;
                    }
                    *v -= 1;
                } else {
                    return false;
                }
            }
        }
        true
    }
}