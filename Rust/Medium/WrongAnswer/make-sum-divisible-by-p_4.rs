impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let mut sum = nums.iter().fold(0, |acc, x| acc + x);
        if sum % p == 0 {
            return 0;
        }
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        let mut min = nums.len() as i32;
        let mut cur = 0;
        for (i, &x) in nums.iter().enumerate() {
            cur = (cur + x) % p;
            map.insert(cur, i as i32);
        }
        cur = 0;
        for (i, &x) in nums.iter().enumerate() {
            cur = (cur + x) % p;
            let target = (sum - x) % p;
            if let Some(&j) = map.get(&target) {
                if j >= i as i32 {
                    min = min.min(j - i as i32);
                }
            }
        }
        if min == nums.len() as i32 {
            -1
        } else {
            min
        }
    }
}