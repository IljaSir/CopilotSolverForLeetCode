impl Solution {
    pub fn two_out_of_three(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for num in nums1 {
            map.insert(num, map.get(&num).unwrap_or(&0) + 1);
        }
        for num in nums2 {
            map.insert(num, map.get(&num).unwrap_or(&0) + 1);
        }
        for num in nums3 {
            map.insert(num, map.get(&num).unwrap_or(&0) + 1);
        }
        for (k, v) in map {
            if v >= 2 {
                result.push(k);
            }
        }
        result
    }
}