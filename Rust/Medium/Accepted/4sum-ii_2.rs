impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        

        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for i in nums1 {
            for j in &nums2 {
                *map.entry(i + j).or_insert(0) += 1;
            }
        }
        let mut res = 0;
        for i in &nums3 {
            for j in &nums4 {
                res += map.get(&(0 - i - j)).unwrap_or(&0);
            }
        }
        res
    }
}