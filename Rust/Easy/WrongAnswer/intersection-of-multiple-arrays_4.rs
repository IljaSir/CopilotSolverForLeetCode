impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in 0..nums[i].len() {
                if let Some(v) = map.get_mut(&nums[i][j]) {
                    *v += 1;
                } else {
                    map.insert(nums[i][j], 1);
                }
            }
        }
        for (k, v) in map {
            if v == nums.len() {
                ans.push(k);
            }
        }
        ans
    }
}