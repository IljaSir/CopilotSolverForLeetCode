impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        while right < nums.len() {
            map.entry(nums[right]).and_modify(|e| *e += 1).or_insert(1);
            if map[&nums[right]] == k {
                count += 1;
            }
            while left <= right && map[&nums[right]] > k {
                map.entry(nums[left]).and_modify(|e| *e -= 1);
                if map[&nums[left]] == k - 1 {
                    count -= 1;
                }
                left += 1;
            }
            res += count;
            right += 1;
        }
        res
    }
}