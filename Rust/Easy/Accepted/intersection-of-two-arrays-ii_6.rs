impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for num in nums1 {
            let entry = map.entry(num).or_insert(0);
            *entry += 1;
        }
        let mut result = Vec::new();
        for num in nums2 {
            if let Some(entry) = map.get_mut(&num) {
                if *entry > 0 {
                    result.push(num);
                    *entry -= 1;
                }
            }
        }
        result
    }
}